import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Equipo } from 'src/app/_model/equipo';
import { EquipoService } from 'src/app/_service/equipo.service';

@Component({
  selector: 'app-equipo',
  templateUrl: './equipo.component.html',
  styleUrls: ['./equipo.component.css']
})
export class EquipoComponent implements OnInit {
  dataSource:MatTableDataSource<Equipo>
  displayedColumns=[]
  constructor(private equipoService:EquipoService) { }

  ngOnInit() {
    this.equipoService.listar().subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
  }

}
