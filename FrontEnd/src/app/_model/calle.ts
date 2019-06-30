import { Distrito } from './distrito'
import { Cancha } from './cancha'

export class Calle {
    id: number;
    nombre: string;
    distrito: Distrito;
    canchas: Cancha[];
}