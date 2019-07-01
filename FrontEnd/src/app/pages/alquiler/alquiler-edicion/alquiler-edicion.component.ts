import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Alquiler } from 'src/app/_model/alquiler';
import { Cancha } from 'src/app/_model/cancha';
import { ActivatedRoute, Router } from '@angular/router';
import { AlquilerService } from 'src/app/_service/alquiler.service';
import { Equipo } from 'src/app/_model/equipo';

@Component({
  selector: 'app-alquiler-edicion',
  templateUrl: './alquiler-edicion.component.html',
  styleUrls: ['./alquiler-edicion.component.css']
})
export class AlquilerEdicionComponent implements OnInit {

  id: number;
  form: FormGroup;
  alquiler: Alquiler;
  cancha:Cancha;
  equipo:Equipo;
  edicion: boolean = false;

  constructor(private route: ActivatedRoute, private router: Router, 
    private alquilerService: AlquilerService ) { 
      this.form = new FormGroup( {
        'id': new FormControl(0),
        'horas': new FormControl('')
      });

    }

  ngOnInit() {
    this.alquiler = new Alquiler();
  }

  grabar() {
    this.alquiler.cancha = new Cancha;
    this.alquiler.id = null;
    this.alquiler.numHoras = this.form.value['horas'];

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

    }
  }

}
