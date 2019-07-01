import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Equipo } from '../_model/equipo';
import { HOST } from '../_shared/var.constant';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {
url:string=`${HOST}/equipo`;
  constructor(private http:HttpClient) { }
  listar(){
    return this.http.get<Equipo[]>(this.url);
  }
  listarEquipoPorId(id:number){
    return this.http.get<Equipo>(`${this.url}/${id}`);
  }
  registrar(equipo:Equipo){
    return this.http.post(this.url,equipo);
  }
  modificar(equipo:Equipo){
    return this.http.put(this.url,equipo);
  }
  eliminar(id:number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
