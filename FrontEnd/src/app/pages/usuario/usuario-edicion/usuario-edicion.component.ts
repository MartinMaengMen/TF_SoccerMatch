import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/_model/usuario';
import { UsuarioService } from 'src/app/_service/usuario.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { AuthService } from 'src/app/_service/auth-service.service';
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
form:FormGroup;
  constructor(private route: ActivatedRoute, private router: Router, private usuarioService:UsuarioService, private authService: AuthService) {
    this.form = new FormGroup( {
      'id':new FormControl(0),
      'usuario': new FormControl(''),
      'nombre': new FormControl(''),
      'password': new FormControl(''),
      'cpassword': new FormControl(''),
      'dni': new FormControl(''),
      'telefono': new FormControl('')        
    });
   }

  ngOnInit() {
    this.usuario = new Usuario();
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
    this.usuario.id = null;
    this.usuario.nombre = this.form.value['nombre'];
    this.usuario.password = this.form.value['password'];
    this.usuario.dni = this.form.value['dni'];
    this.usuario.username = this.form.value['usuario'];
    this.usuario.numtelefono = this.form.value['telefono'];

    if( this.edicion ) {
      this.usuarioService.modificar( this.usuario ).subscribe( data => {
        this.usuarioService.listar().subscribe( usuarios => {
          // para actualizar la lista
          this.usuarioService.usuarioCambio.next(usuarios);
        } );
      } );
    }
    else {
      this.usuarioService.registrar( this.usuario ).subscribe( data => {
        this.usuarioService.listar().subscribe( usuarios => {
          // para actualizar la lista
            this.usuarioService.usuarioCambio.next(usuarios);
        });
      });

    }
    this.router.navigate( [`usuario`] );
  }
}
