import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { AuthService } from 'src/app/_service/auth-service.service';
import { Equipo } from 'src/app/_model/equipo';
import { Usuario } from 'src/app/_model/usuario';
import { Alquiler } from 'src/app/_model/alquiler';

@Component({
  selector: 'app-detalleequipo',
  templateUrl: './detalleequipo.component.html',
  styleUrls: ['./detalleequipo.component.css']
})
export class DetalleequipoComponent implements OnInit {
  id: number;
  dataSource:MatTableDataSource<Usuario>
  displayedColumns=['Nombre', 'username', 'numtelf']
  constructor(private participanteService:ParticipanteService, private authService: AuthService) { }

  ngOnInit() {
    this.participanteService.listarMiembros(Number(this.authService.getIdEquipo())).subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
  }
}

export class detalleEquipo implements OnInit {

  id: number;
  dataSource:MatTableDataSource<Alquiler>
  displayedColumns=['idequipo', 'idcancha', 'numhoras', 'horainicio','estadopagado']

  constructor(private participanteService:ParticipanteService, private authService: AuthService) { }
  ngOnInit() {
    this.participanteService.listarAlquiler(Number(this.authService.getIdAlquiler())).subscribe(data=>{this.dataSource=new MatTableDataSource(data);});

  }

}