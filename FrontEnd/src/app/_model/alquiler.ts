import { Equipo } from './equipo'
import { Cancha } from './cancha'
import { DetalleParticipante } from './detalleparticipante'

export class Alquiler {
    id: number;
    equipo: Equipo;
    cancha: Cancha;
    horaInicio: Date;
    numHoras: number;
    descuento: number;
    total: number;
    estadoPagado: Boolean;
}