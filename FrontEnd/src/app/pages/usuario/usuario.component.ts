import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/_model/usuario';
import { UsuarioService } from 'src/app/_service/usuario.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { MatTableDataSource } from '@angular/material';
import { ThrowStmt } from '@angular/compiler';
@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  dataSource:MatTableDataSource<Usuario>
  usuario:Usuario;
  form:FormGroup;
  data:[]
  constructor(private route: ActivatedRoute, private router: Router, private usuarioService:UsuarioService) {
    this.form = new FormGroup( {
      'usuario': new FormControl(''),
      'contraseña': new FormControl('')   
    });
   }

  ngOnInit() {
    this.usuario=new Usuario();
    this.usuarioService.listar().subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
  }
  operar() {
    this.usuario.password = this.form.value['contraseña'];
    this.usuario.username = this.form.value['usuario'];
    for(var i=0;i<this.dataSource.data.length;i++)
      if(this.usuario.password==this.dataSource.data[i].password&&this.usuario.username==this.dataSource.data[i].username)
      { this.router.navigate( ['cancha'] );}
  }
}
