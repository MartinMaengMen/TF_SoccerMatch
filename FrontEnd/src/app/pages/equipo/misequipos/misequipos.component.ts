import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Equipo } from 'src/app/_model/equipo';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { AuthService } from 'src/app/_service/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-misequipos',
  templateUrl: './misequipos.component.html',
  styleUrls: ['./misequipos.component.css']
})
export class MisequiposComponent implements OnInit {
  dataSource:MatTableDataSource<Equipo>
  
  displayedColumns=['idEquipo', 'nombre', 'descripcion', 'distrito', 'seleccionar']
  constructor(private router: Router, private participanteService:ParticipanteService,
    private authService : AuthService ) {
      this.participanteService.listarEquipoPorUsuario(Number(this.authService.getIdJugador())).subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
     }

  ngOnInit() {
  }
  redirigir(id: number)
  {
    this.authService.setIdEquipo(id);
    this.router.navigate([`equipo/detallemisequipos/${this.authService.getIdEquipo}`]);
  }

}
