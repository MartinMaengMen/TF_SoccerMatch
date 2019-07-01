import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Equipo } from 'src/app/_model/equipo';
import { EquipoService } from 'src/app/_service/equipo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-equipo',
  templateUrl: './equipo.component.html',
  styleUrls: ['./equipo.component.css']
})
export class EquipoComponent implements OnInit {
  id: number;
  dataSource:MatTableDataSource<Equipo>
  displayedColumns=['idEquipo', 'nombre', 'descripcion', 'distrito']
  constructor(private router: Router, private equipoService:EquipoService) { }

  ngOnInit() {
  }

}
