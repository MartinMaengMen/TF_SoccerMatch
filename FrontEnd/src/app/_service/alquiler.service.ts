import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from 'src/app/_shared/var.constant';
import { Subject } from 'rxjs';
import { Alquiler } from '../_model/alquiler';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {
  url: string = `${HOST}/alquiler`;
  alquilerCambio = new Subject< Alquiler[] >();
  constructor( private http: HttpClient ) { }

  listar() {
    return this.http.get<Alquiler[]>(this.url);
  }
  listarAlquilerPorId( id: number ) {
    return this.http.get<Alquiler>(`${this.url}/${id}`);
  }
  registrar( alquiler: Alquiler ) {
    return this.http.post(this.url, alquiler);
  }
  modificar( alquiler: Alquiler ) {
    return this.http.put( this.url, alquiler );
  }
  eliminar( id: number ) {
    return this.http.delete( `${this.url}/${id}` );
  }
}
