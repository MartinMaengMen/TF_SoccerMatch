import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/_model/usuario';
import { MatTableDataSource } from '@angular/material';
import { UsuarioService } from 'src/app/_service/usuario.service';
@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
dataSource:MatTableDataSource<Usuario>;
displayedColumns=['id','dni','nombre','numtelefono','username','password'];
  constructor(private usuarioService:UsuarioService) { }

  ngOnInit() {
    this.usuarioService.listar().subscribe(data=>{this.dataSource=new MatTableDataSource(data);});
  }

}
