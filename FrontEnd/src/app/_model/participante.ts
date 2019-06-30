import { Jugador } from './jugador'
import { Equipo } from './equipo'
import { DetalleParticipante } from './detalleparticipante'

export class Participante{
    id: number;
    jugador: Jugador;
    equipo: Equipo;
    esAdministrador: Boolean;
    detallesparticipante: DetalleParticipante[];
}