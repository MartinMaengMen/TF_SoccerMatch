import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/_service/usuario/usuario.service';
import { FormGroup } from '@angular/forms';

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
  constructor(private route:ActivatedRoute,private router: Router,private usuarioService:UsuarioService) { 
  }

  ngOnInit() {
  }

}
