import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { UsuarioEdicionComponent } from './pages/usuario/usuario-edicion/usuario-edicion.component';
import { CanchaComponent } from './pages/cancha/cancha.component'
import { CanchaEdicionComponent } from './pages/cancha/cancha-edicion/cancha-edicion.component'
import { ParticipanteComponent } from './pages/participante/participante.component'
import { ParticipanteEditComponent } from './pages/participante/participante-edit/participante-edit.component'


const routes: Routes = [
  {path:'usuario',component:UsuarioComponent,children:[
    {path:'nuevo',component:UsuarioEdicionComponent},
    {path:'edicion/:id',component:UsuarioEdicionComponent}
  ]},
  {path:'cancha/:idUsuario',component:CanchaComponent,children:[
    {path:'nuevo',component:CanchaEdicionComponent},
    {path:'edicion/:id',component:CanchaEdicionComponent}
  ]},

  {path:'participante',component:ParticipanteComponent,children:[
    {path:'nuevo',component:ParticipanteEditComponent},
    {path:'participante/misequipos',component:ParticipanteEditComponent},
    {path:'participante/equiposrecomendados',component:ParticipanteEditComponent}
  ]}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
