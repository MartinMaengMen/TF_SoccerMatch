import { Injectable } from '@angular/core';
import { DetalleParticipante } from '../_model/detalleparticipante';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';

@Injectable({
  providedIn: 'root'
})
export class DetalleParticipanteService {
  url: string = `${HOST}/detalleparticipante`;
  detalleparticipanteCambio = new Subject< DetalleParticipante[] >();
  constructor( private http: HttpClient ) { }

  listar() {
    return this.http.get<DetalleParticipante[]>(this.url);
  }
  listarDetalleParticipantePorId( id: number ) {
    return this.http.get<DetalleParticipante>(`${this.url}/${id}`);
  }
  registrar( detalleparticipante: DetalleParticipante ) {
    return this.http.post(this.url, detalleparticipante);
  }
  modificar( detalleparticipante: DetalleParticipante ) {
    return this.http.put( this.url, detalleparticipante );
  }
  eliminar( id: number ) {
    return this.http.delete( `${this.url}/${id}` );
  }
}