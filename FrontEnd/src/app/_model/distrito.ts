import { Ciudad } from './ciudad'
import { Calle } from './calle'
import { Equipo } from './equipo';

export class Distrito {
    id: number;
    nombre: string;
    ciudad: Ciudad;
    calles: Calle[];
    equipos: Equipo[];
}