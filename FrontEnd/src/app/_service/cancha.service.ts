import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cancha } from '../_model/cancha';
import { HOST } from '../_shared/var.constant';

@Injectable({
  providedIn: 'root'
})
export class CanchaService {
  url: string = `${HOST}/cancha`;
  constructor(private http:HttpClient) { }
  listar(){
    return this.http.get<Cancha[]>(this.url);
  }
  listarCanchaPorId(id:number){
    return this.http.get<Cancha>(`${this.url}/${id}`);
  }
  listarCanchaPorUsuario(id: number){
    return this.http.get<Cancha[]>(`${this.url}/usuario/${id}`);
  }
  registrar(cancha:Cancha){
    return this.http.post(this.url,cancha);
  }
  modificar(cancha:Cancha){
    return this.http.post(this.url,cancha);
  }
  eliminar(id:number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
