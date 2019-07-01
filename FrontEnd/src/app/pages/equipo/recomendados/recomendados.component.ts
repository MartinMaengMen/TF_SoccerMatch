import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Equipo } from 'src/app/_model/equipo';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { AuthService } from 'src/app/_service/auth-service.service';

@Component({
  selector: 'app-recomendados',
  templateUrl: './recomendados.component.html',
  styleUrls: ['./recomendados.component.css']
})
export class RecomendadosComponent implements OnInit {
  id: number;
  dataSource:MatTableDataSource<Equipo>
  displayedColumns=['idEquipo', 'nombre', 'descripcion', 'distrito']
  constructor(private participanteService:ParticipanteService, private authService: AuthService) { }

  ngOnInit() {
    this.participanteService.listarRecomendados(Number(this.authService.getToken())).subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
  }

}