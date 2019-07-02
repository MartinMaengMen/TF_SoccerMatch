import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Participante } from 'src/app/_model/participante';
import { Equipo } from 'src/app/_model/equipo';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ParticipanteService } from 'src/app/_service/participante.service';
import { AuthService } from 'src/app/_service/auth-service.service';
import { EquipoService } from 'src/app/_service/equipo.service';
import { FormGroup, FormControl } from '@angular/forms';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { participanteService } from 'src/app/_service/participante/participante.service';
import { AppModule } from 'src/app/app.module';
import { Usuario } from 'src/app/_model/usuario';
import { JugadorService } from 'src/app/_service/jugador.service';

@Component({
  selector: 'app-nuevoequipo',
  templateUrl: './nuevoequipo.component.html',
  styleUrls: ['./nuevoequipo.component.css']
})
export class nuevoequipo implements OnInit {

  dataSource:MatTableDataSource<Equipo>
  form: FormGroup;
  Equipo: Equipo;
  data: []

  id:number;
  nombre:string;
  
  Participante:Participante;

  constructor( private route: ActivatedRoute, private router: Router, 
    private equiposervice: EquipoService, private participanteservice : ParticipanteService,
    private authservice: AuthService,
    private jugadorservice:JugadorService ) {
      // Crearmos el objeto para vincularlo y jalar los datos
      this.form = new FormGroup( {
        'nombre': new FormControl(0),
        'descripcion': new FormControl(''),
        'fechaJuego': new FormControl(''),
        'distrito': new FormControl(''),
      });
     }
       
  ngOnInit() {
    this.Equipo = new Equipo();
    this.Participante = new Participante();
 
  }

  initForm() {}



  grabar() {
    //this.estudiante.id = this.form.value['id'];
    this.Equipo.id = null;
    this.Equipo.nombre = this.form.value['nombre'];
    this.Equipo.descripcion = this.form.value['descripcion'];
    this.Equipo.numParticipantes = 1;
    this.Equipo.fechaJuego = this.form.value['fechajuego'];
    this.Equipo.participantes = null;
    this.Equipo.alquileres = null;
    this.Equipo.distrito = this.form.value['distrito'];



    this.equiposervice.registrar( this.Equipo ).subscribe( data => {
      this.equiposervice.listar().subscribe( Equipo => {
        this.equiposervice.equipoCambio.next(Equipo);
      } );

      this.Participante.id = null;
      this.Participante.jugador = null;
      this.Participante.esAdministrador = true;
      this.Participante.equipo = this.Equipo;
      this.Participante.detallesparticipante = null;

      this.participanteservice.registrar(this.Participante)
     });
}}