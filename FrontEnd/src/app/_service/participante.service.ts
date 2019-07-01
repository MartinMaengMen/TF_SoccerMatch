import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Participante } from 'src/app/_model/participante';
import { HOST } from 'src/app/_shared/var.constant';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class participanteService {
  url: string = `${HOST}/participante`;
  participanteCambio = new Subject< Participante[] >();
  constructor( private http: HttpClient ) { }

  listar() {
    return this.http.get<Participante[]>(this.url);
  }
  listarparticipantePorId( id: number ) {
    return this.http.get<Participante>(`${this.url}/${id}`);
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
