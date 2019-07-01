import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Equipo } from 'src/app/_model/equipo';
import { EquipoService } from 'src/app/_service/equipo.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Distrito } from 'src/app/_model/distrito';

@Component({
  selector: 'app-misequipos-edicion',
  templateUrl: './misequipos-edicion.component.html',
  styleUrls: ['./misequipos-edicion.component.css']
})
export class MisequiposEdicionComponent implements OnInit {
  id: number;
  form: FormGroup;
  equipo: Equipo;
  distrito: Distrito;
  edicion: boolean = false;

  constructor(private route: ActivatedRoute, private router: Router, 
    private equipoService: EquipoService ) { 
      this.form = new FormGroup( {
        'id': new FormControl(0),
        'nombre': new FormControl(''),
        'descripcion': new FormControl(''),
        'distrito': new FormControl('')
      });

    }

  ngOnInit() {
    this.equipo = new Equipo();
  }

  grabar() {
    this.equipo.distrito = new Distrito;
    this.equipo.id = null;
    this.equipo.nombre = this.form.value['nombre'];
    this.equipo.distrito.nombre = this.form.value['distrito'];
    this.equipo.descripcion = this.form.value['descripcion'];

    if( this.edicion ) {
      this.equipoService.modificar( this.equipo ).subscribe( data => {
        this.equipoService.listar().subscribe( equipos => {
          // para actualizar la lista
          this.equipoService.equipoCambio.next(equipos);
        } );
      } );
    }
    else {
      this.equipoService.registrar( this.equipo ).subscribe( data => {
        this.equipoService.listar().subscribe( equipos => {
          // para actualizar la lista
            this.equipoService.equipoCambio.next(equipos);
        });
      });

    }
  }
}
