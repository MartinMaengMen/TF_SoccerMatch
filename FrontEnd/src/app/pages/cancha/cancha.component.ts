import { Component, OnInit } from '@angular/core';
import { MatTableDataSource} from '@angular/material'
import { Cancha } from 'src/app/_model/cancha';
import { CanchaService } from 'src/app/_service/cancha.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
@Component({
  selector: 'app-cancha',
  templateUrl: './cancha.component.html',
  styleUrls: ['./cancha.component.css']
})
export class CanchaComponent implements OnInit {
id: number;
dataSource:MatTableDataSource<Cancha>
displayedColumns=['idCancha','nombre','direccion','preciohora','propietario'];
constructor(private route: ActivatedRoute, private router: Router, private canchaService:CanchaService) { 
}

  ngOnInit() {
    this.route.params.subscribe( ( params: Params ) => {
      this.id = params['idUsuario'];
    } )
    //this.canchaService.listar().subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
    this.canchaService.listarCanchaPorUsuario(this.id).subscribe(data=>{this.dataSource = new MatTableDataSource(data);});
  }
}
