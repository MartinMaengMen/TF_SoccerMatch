import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Jugador } from 'src/app/_model/Jugador';
import { HOST } from 'src/app/_shared/var.constant';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JugadorService {
  url: string = `${HOST}/jugador`;
  JugadorCambio = new Subject< Jugador[] >();
  constructor( private http: HttpClient ) { }

  listar() {
    return this.http.get<Jugador[]>(this.url);
  }
  listarJugadorPorId( id: number ) {
    return this.http.get<Jugador>(`${this.url}/${id}`);
  }
  registrar( Jugador: Jugador ) {
    return this.http.post(this.url, Jugador);
  }
  modificar( Jugador: Jugador ) {
    return this.http.put( this.url, Jugador );
  }
  eliminar( id: number ) {
    return this.http.delete( `${this.url}/${id}` );
  }
}


