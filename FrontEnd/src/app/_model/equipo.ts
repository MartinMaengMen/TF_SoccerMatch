import { Distrito } from './distrito'
import { Participante } from './participante'
import { Alquiler } from './alquiler';

export class Equipo {
    id:number;
    distrito : Distrito;
    participantes: Participante[];
    alquileres: Alquiler[];
    nombre:string;
    descripcion:string;
    numParticipantes:number;
    fechaJuego:Date;
}
