import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { map } from "rxjs/operators";
import { isNullOrUndefined } from "util";
import { Usuario } from '../_model/usuario';

@Injectable({
  providedIn: "root"
})
export class AuthService {
  constructor(private htttp: HttpClient) {}
  headers: HttpHeaders = new HttpHeaders({
    "Content-Type": "application/json"
  });

  registerUser(nombre: string, dni : string, num_telefono : number, password: string, username: string) {
    const url_api = "http://localhost:4200/api/usuario";
    return this.htttp
      .post<Usuario>(
        url_api,
        {
          nombre: nombre,
          dni: dni,
          num_telefono: num_telefono,
          password: password,
          username: username
        },
        { headers: this.headers }
      )
      .pipe(map(data => data));
  }

  setUser(user: Usuario): void {
    let user_string = JSON.stringify(user);
    localStorage.setItem("currentUser", user_string);
  }

  setToken(token): void {
    localStorage.setItem("accessToken", token);
  }

  getToken() {
    return localStorage.getItem("accessToken");
  }

  getCurrentUser(): Usuario {
    let user_string = localStorage.getItem("currentUser");
    if (!isNullOrUndefined(user_string)) {
      let user: Usuario = JSON.parse(user_string);
      return user;
    } else {
      return null;
    }
  }

  logoutUser() {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("currentUser");
  }
}