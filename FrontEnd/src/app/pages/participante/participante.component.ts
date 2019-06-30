import { Component, OnInit } from '@angular/core';
import { MatTableDataSource} from '@angular/material'
import { Participante } from 'src/app/_model/participante';
import { participanteService } from 'src/app/_service/participante.service';

@Component({
  selector: 'app-participante',
  templateUrl: './participante.component.html',
  styleUrls: ['./participante.component.css']
})
export class ParticipanteComponent implements OnInit {
dataSource:MatTableDataSource<Participante>
displayedColumns=['idparticipante','nombre','direccion','preciohora','propietario'];
constructor() { }

  ngOnInit() {
  }

}
