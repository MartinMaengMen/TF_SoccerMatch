import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/_service/auth-service.service';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { Jugador } from 'src/app/_model/jugador';

@Component({
  selector: 'app-participante-edit',
  templateUrl: './participante-edit.component.html',
  styleUrls: ['./participante-edit.component.css']
})
export class ParticipanteEditComponent implements OnInit {
  

  constructor(authService: AuthService, participanteService: ParticipanteService) { }

  ngOnInit() {
  }

  redirigir(){

  }

}
