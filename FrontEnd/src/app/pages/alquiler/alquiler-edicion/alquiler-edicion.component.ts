import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Alquiler } from 'src/app/_model/alquiler';
import { Cancha } from 'src/app/_model/cancha';
import { ActivatedRoute, Router } from '@angular/router';
import { AlquilerService } from 'src/app/_service/alquiler.service';
import { Equipo } from 'src/app/_model/equipo';
import { AuthService } from 'src/app/_service/auth-service.service';
import { MatTableDataSource } from '@angular/material';
import { CanchaService } from 'src/app/_service/cancha.service';

@Component({
  selector: 'app-alquiler-edicion',
  templateUrl: './alquiler-edicion.component.html',
  styleUrls: ['./alquiler-edicion.component.css']
})
export class AlquilerEdicionComponent implements OnInit {
  id: number;
  dataSource:MatTableDataSource<Cancha>
  displayedColumns=['idCancha','nombre','direccion','preciohora','propietario'];
  idEquipo:number;
  form: FormGroup;
  alquiler: Alquiler;
  cancha:Cancha;
  equipo:Equipo;
  edicion: boolean = false;

  constructor(private route: ActivatedRoute, private router: Router, 
    private alquilerService: AlquilerService, private authService: AuthService, private canchaService:CanchaService ) { 
      this.idEquipo = Number(this.authService.getIdEquipo());
      this.form = new FormGroup( {
        'idCancha': new FormControl(''),
        'numHoras': new FormControl(''),
        'horaInicio': new FormControl(''),
      });

    }

  ngOnInit() {
    this.alquiler = new Alquiler();
    this.cancha = new Cancha();
    this.equipo = new Equipo();
    this.alquiler.cancha = this.cancha;
    this.alquiler.equipo = this.equipo;
    this.id = Number(this.authService.getIdJugador);
    this.canchaService.listar().subscribe(data=>{this.dataSource = new MatTableDataSource(data);});
  }

  grabar() {
    this.alquiler.cancha.id = this.form.value['idCancha'];
    this.alquiler.equipo.id = Number(this.authService.getIdEquipo());
    this.alquiler.estadoPagado = false;
    this.alquiler.descuento = 0;
    this.alquiler.numHoras = this.form.value['numHoras'];
    this.alquiler.horaInicio = this.form.value['horaInicio'];    
    this.alquiler.total = 60;

    if( this.edicion ) {
      this.alquilerService.modificar( this.alquiler ).subscribe( data => {
        this.alquilerService.listar().subscribe( alquilers => {
          // para actualizar la lista
          this.alquilerService.alquilerCambio.next(alquilers);
        } );
      } );
    }
    else {
      this.alquilerService.registrar( this.alquiler ).subscribe( data => {
        this.alquilerService.listar().subscribe( alquilers => {
          // para actualizar la lista
            this.alquilerService.alquilerCambio.next(alquilers);
        });
      });
      this.router.navigate([`equipo/misequipos/${this.authService.getIdJugador()}`]);
    }
  }

}
