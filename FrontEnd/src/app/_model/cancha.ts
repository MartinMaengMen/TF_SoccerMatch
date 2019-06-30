import { Calle } from './calle'
import { Propietario } from './propietario'
import { Alquiler } from './alquiler'

export class Cancha {
    id: number;
    propietario: Propietario;
    calle: Calle;
    alquileres: Alquiler[];
    nombre: string;
    direccion: string;
    precioHora: number;
}
