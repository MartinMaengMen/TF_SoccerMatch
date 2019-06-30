import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from 'src/app/_model/usuario';
import { HOST } from 'src/app/_shared/var.constant';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  url: string = `${HOST}/usuario`;
  constructor( private http: HttpClient ) { }

  listar() {
    return this.http.get<Usuario[]>(this.url);
  }
  listarUsuarioPorId( id: number ) {
    return this.http.get<Usuario>(`${this.url}/${id}`);
  }
  registrar( usuario: Usuario ) {
    return this.http.post(this.url, usuario);
  }
  modificar( usuario: Usuario ) {
    return this.http.put( this.url, usuario );
  }
  eliminar( id: number ) {
    return this.http.delete( `${this.url}/${id}` );
  }

}
