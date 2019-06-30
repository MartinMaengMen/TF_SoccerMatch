import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { UsuarioEdicionComponent } from './pages/usuario/usuario-edicion/usuario-edicion.component';
import { CanchaComponent } from './pages/cancha/cancha.component'
import { CanchaEdicionComponent } from './pages/cancha/cancha-edicion/cancha-edicion.component'

const routes: Routes = [
  {path:'usuario',component:UsuarioComponent,children:[
    {path:'nuevo',component:UsuarioEdicionComponent},
    {path:'edicion/:id',component:UsuarioEdicionComponent}
  ]},
  {path:'cancha/:idUsuario',component:CanchaComponent,children:[
    {path:'nuevo',component:CanchaEdicionComponent},
    {path:'edicion/:id',component:CanchaEdicionComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
