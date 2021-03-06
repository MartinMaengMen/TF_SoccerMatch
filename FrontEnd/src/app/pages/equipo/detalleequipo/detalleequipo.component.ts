import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { AuthService } from 'src/app/_service/auth-service.service';
import { Usuario } from 'src/app/_model/usuario';
import { Alquiler } from 'src/app/_model/alquiler';
import { Router } from '@angular/router';

@Component({
  selector: 'app-detalleequipo',
  templateUrl: './detalleequipo.component.html',
  styleUrls: ['./detalleequipo.component.css']
})
export class DetalleequipoComponent implements OnInit {
  id: number;
  dataSourceMiembros:MatTableDataSource<Usuario>
  dataSourceAlquileres:MatTableDataSource<Alquiler>
  displayedColumnsMiembros=['nombre', 'username', 'numtelefono']
  displayedColumnsAlquileres=['equipo', 'cancha','distrito', 'numhoras', 'horainicio']
  constructor(private route: Router, private participanteService:ParticipanteService, private authService: AuthService) { }

  ngOnInit() {
    this.id = Number(this.authService.getIdJugador());
    this.participanteService.listarMiembros(Number(this.authService.getIdEquipo())).subscribe(data=>{this.dataSourceMiembros=new MatTableDataSource(data);});
    this.participanteService.listarAlquiler(Number(this.authService.getIdEquipo())).subscribe(data=>{this.dataSourceAlquileres=new MatTableDataSource(data);});
  }
  redirigir()
  {
    this.route.navigate(['/participante/nuevo']);
  }
}