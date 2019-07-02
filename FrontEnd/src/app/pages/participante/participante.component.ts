import { Component, OnInit } from '@angular/core';
import { MatTableDataSource} from '@angular/material'
import { Participante } from 'src/app/_model/participante';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-participante',
  templateUrl: './participante.component.html',
  styleUrls: ['./participante.component.css']
})
export class ParticipanteComponent implements OnInit {
dataSource:MatTableDataSource<Participante>
participante:Participante;
form:FormGroup;
data:[];
displayedColumns=['idparticipante','nombre','direccion','preciohora','propietario'];
constructor() { }

  ngOnInit() {
    this.participante = new Participante;
  }

}
