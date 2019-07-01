import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Participante } from 'src/app/_model/participante';
import { HOST } from 'src/app/_shared/var.constant';
import { Subject } from 'rxjs';
import { Equipo } from '../_model/equipo';
import { Alquiler } from '../_model/alquiler';
import { Usuario } from '../_model/usuario';

@Injectable({
  providedIn: 'root'
})
export class ParticipanteService {
  url: string = `${HOST}/participante`;
  participanteCambio = new Subject< Participante[] >();
  constructor( private http: HttpClient ) { }

  listar() {
    return this.http.get<Participante[]>(this.url);
  }
  listarparticipantePorId( id: number ) {
    return this.http.get<Participante>(`${this.url}/${id}`);
  }
  listarEquipoPorUsuario(id: number){
    return this.http.get<Equipo[]>(`${this.url}/jugador/${id}`);
  }
  listarRecomendados(id: number){
    return this.http.get<Equipo[]>(`${this.url}/recomendados/${id}`);
  }
    listarAlquiler(id: number){
    return this.http.get<Alquiler[]>(`${this.url}/alquiler/${id}`);
  }
  listarMiembros(id: number){
    return this.http.get<Usuario[]>(`${this.url}/equipo/${id}`);
  }
  registrar( participante: Participante ) {
    return this.http.post(this.url, participante);
  }
  modificar( participante: Participante ) {
    return this.http.put( this.url, participante );
  }
  eliminar( id: number ) {
    return this.http.delete( `${this.url}/${id}` );
  }

}
