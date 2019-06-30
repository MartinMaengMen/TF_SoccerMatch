import { Alquiler } from './alquiler'
import { Participante } from './participante'

export class DetalleParticipante {
    id: number;
    alquiler: Alquiler;
    participante: Participante;
    cuota: number;
    pagado: Boolean;
}