import { Usuario } from './usuario'
import { Participante } from './participante'

export class Jugador {
    id:number;
    usuario: Usuario;
    participantes: Participante[];
    direccion: string;
}