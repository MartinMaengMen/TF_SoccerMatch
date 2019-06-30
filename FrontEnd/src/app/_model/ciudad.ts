import { Departamento } from './departamento'
import { Distrito } from './distrito'

export class Ciudad {
    id: number;
    nombre: string;
    departamentos: Departamento;
    distritos:  Distrito[];
}