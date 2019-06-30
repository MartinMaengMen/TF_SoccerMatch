import { Jugador } from './jugador'
import { Propietario } from './propietario'

export class Usuario {
    id:number;
    jugador: Jugador;
    propietario: Propietario;
    dni:number;
    nombre:string;
    numTelefono:number;
    username:string;
    password:string;
}
