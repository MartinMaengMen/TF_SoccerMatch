import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/_model/usuario';
import { UsuarioService } from 'src/app/_service/usuario.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { AuthService } from 'src/app/_service/auth-service.service';
import { Jugador } from 'src/app/_model/jugador';
import { JugadorService } from 'src/app/_service/jugador.service';
@Component({
  selector: 'app-usuario-edicion',
  templateUrl: './usuario-edicion.component.html',
  styleUrls: ['./usuario-edicion.component.css']
})
export class UsuarioEdicionComponent implements OnInit {
  id:number;
  dni:number;
  nombre:string;
  numTelefono:number;
  username:string;
  password:string;
  usuario:Usuario;
  edicion: boolean = false;
  jugador: Jugador;
  direccion: string;
  form:FormGroup;
  constructor(private route: ActivatedRoute, private router: Router, private usuarioService:UsuarioService, private jugadorService:JugadorService, private authService: AuthService) {
    this.form = new FormGroup( {
      'id':new FormControl(0),
      'usuario': new FormControl(''),
      'nombre': new FormControl(''),
      'password': new FormControl(''),
      'cpassword': new FormControl(''),
      'dni': new FormControl(''),
      'telefono': new FormControl(''),
      'direccion': new FormControl('')
    });
   }

  ngOnInit() {
    //Acá crea el objeto de jugador
    this.jugador = new Jugador();
    this.route.params.subscribe( ( params: Params ) => {
      this.id = params['id'];
      this.edicion = params['id'] != null;
      this.initForm()
    } )
  }
  initForm() {
    /*if( this.edicion ) {
      this.usuarioService.listarUsuarioPorId( this.id ).subscribe( data => {
        this.form = new FormGroup( {
          'id': new FormControl( data.id ),
          'nombre': new FormControl( data.nombre ),
          'password': new FormControl( data.password ),
          'usuario': new FormControl( data.username ),
          'dni': new FormControl( data.dni ),
          'telefono': new FormControl( data.numTelefono )        
        });
      } );
    }*/
  }
  operar() {
    //acá crea el objeto de Usuario necesario para insertar en la base de datos y lo vincula con el objeto de jugador ya creado
    this.jugador.usuario = new Usuario();
    this.jugador.usuario.id = null;
    this.jugador.usuario.nombre = this.form.value['nombre'];
    this.jugador.usuario.password = this.form.value['password'];
    this.jugador.usuario.dni = this.form.value['dni'];
    this.jugador.usuario.username = this.form.value['usuario'];
    this.jugador.usuario.numtelefono = this.form.value['telefono'];

    //añadiendo jugador
    this.jugador.id = null;
    this.jugador.direccion = this.form.value['direccion'];

    if( this.edicion ) {
      this.jugadorService.modificar( this.jugador ).subscribe( data => {
        this.jugadorService.listar().subscribe( jugadores => {
          // para actualizar la lista
          this.jugadorService.JugadorCambio.next(jugadores);
        } );
      } );
    }
    else {
      this.jugadorService.registrar( this.jugador ).subscribe( data => {
        this.jugadorService.listar().subscribe( jugadores => {
          // para actualizar la lista
            this.jugadorService.JugadorCambio.next(jugadores);
        });
      });

    }
    this.router.navigate( [`usuario`] );
  }
}
