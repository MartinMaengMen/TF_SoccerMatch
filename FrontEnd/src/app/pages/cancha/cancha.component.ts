import { Component, OnInit } from '@angular/core';
import { MatTableDataSource} from '@angular/material'
import { Cancha } from 'src/app/_model/cancha';
import { CanchaService } from 'src/app/_service/cancha.service';
@Component({
  selector: 'app-cancha',
  templateUrl: './cancha.component.html',
  styleUrls: ['./cancha.component.css']
})
export class CanchaComponent implements OnInit {
dataSource:MatTableDataSource<Cancha>
displayedColumns=['idCancha','nombre','direccion','preciohora','propietario'];
constructor(private canchaService:CanchaService) { }

  ngOnInit() {
    this.canchaService.listar().subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
  }

}
