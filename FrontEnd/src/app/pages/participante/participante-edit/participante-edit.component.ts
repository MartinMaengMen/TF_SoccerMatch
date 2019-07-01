import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/_service/auth-service.service';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { Jugador } from 'src/app/_model/jugador';
import { Usuario } from 'src/app/_model/usuario';
import { Equipo } from 'src/app/_model/equipo';
import { Participante } from 'src/app/_model/participante';
import { Router } from '@angular/router';
import { EquipoService } from 'src/app/_service/equipo.service';

@Component({
  selector: 'app-participante-edit',
  templateUrl: './participante-edit.component.html',
  styleUrls: ['./participante-edit.component.css']
})
export class ParticipanteEditComponent implements OnInit {
  jugador:Jugador;
  equipo:Equipo;
  esadministrador:Boolean;
  participante: Participante;

  constructor(private route: Router, private authService: AuthService, private participanteService: ParticipanteService,
    private equipoService: EquipoService) { 
    this.jugador = new Jugador();
    this.equipo = new Equipo();
    this.participante = new Participante();
  }

  ngOnInit() {
    this.jugador.id = Number(this.authService.getIdJugador());
    this.equipo.id = Number(this.authService.getIdEquipo());
    this.esadministrador = false;
    this.participante.equipo = this.equipo;
    this.participante.jugador = this.jugador;
    this.participante.esadministrador = this.esadministrador;
  }

  redirigir(){
      this.participanteService.registrar(this.participante).subscribe( data => {
        this.participanteService.listarEquipoPorUsuario(Number(this.authService.getIdJugador())).subscribe( equipos => {
          // para actualizar la lista
            this.equipoService.equipoCambio.next(equipos);
        });
      });
      this.route.navigate([`/equipo/misequipos/${Number(this.authService.getIdJugador())}`]);
  }

}
