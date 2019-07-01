import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Equipo } from 'src/app/_model/equipo';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { AuthService } from 'src/app/_service/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recomendados',
  templateUrl: './recomendados.component.html',
  styleUrls: ['./recomendados.component.css']
})
export class RecomendadosComponent implements OnInit {
  id: number;
  dataSource:MatTableDataSource<Equipo>
  displayedColumns=['idEquipo', 'nombre', 'descripcion', 'distrito', 'seleccionar']
  constructor(private router:Router ,private participanteService:ParticipanteService, private authService: AuthService) { }

  ngOnInit() {
    this.id = Number(this.authService.getIdUsuario());
    this.participanteService.listarRecomendados(Number(this.authService.getIdUsuario())).subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
  }

  redirigir(id: number)
  {
    this.authService.setIdEquipo(id);
    this.router.navigate([`equipo/detalleequipo/${this.authService.getIdEquipo}`]);
  }
}
