import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { UsuarioEdicionComponent } from './pages/usuario/usuario-edicion/usuario-edicion.component';
import { CanchaComponent } from './pages/cancha/cancha.component'
import { CanchaEdicionComponent } from './pages/cancha/cancha-edicion/cancha-edicion.component'
import { EquipoComponent } from './pages/equipo/equipo.component'
import { EquipoEdicionComponent } from './pages/equipo/equipo-edicion/equipo-edicion.component'
import { ParticipanteComponent } from './pages/participante/participante.component'
import { DetalleequipoComponent } from './pages/equipo/detalleequipo/detalleequipo.component'
import { ParticipanteEditComponent } from './pages/participante/participante-edit/participante-edit.component'
import { MisequiposComponent } from './pages/equipo/misequipos/misequipos.component';
import { RecomendadosComponent } from './pages/equipo/recomendados/recomendados.component';
import { MisequiposEdicionComponent } from './pages/equipo/misequipos/misequipos-edicion/misequipos-edicion.component';
import { nuevoequipo } from './pages/equipo/nuevoequipo/nuevoequipo.component';


const routes: Routes = [
  {path:'usuario',component:UsuarioComponent},
  {path:'usuario/nuevo',component:UsuarioEdicionComponent},
  {path:'cancha',component:CanchaComponent,children:[
    {path:'nuevo',component:CanchaEdicionComponent},
    {path:'edicion/:id',component:CanchaEdicionComponent}
  ]},
  {path:'equipo',component:EquipoComponent,children:[
    {path:'misequipos/:id',component:MisequiposComponent, children:[
      {path: 'nuevo',component: nuevoequipo},
      {path: 'edicion/:id',component: MisequiposEdicionComponent}
    ]},
    {path:'recomendados/:id',component:RecomendadosComponent},
    {path:'nuevo',component:EquipoEdicionComponent},
    {path:'edicion/:id',component:EquipoEdicionComponent},
    {path: 'detalleequipo/:id', component:DetalleequipoComponent}
  ]},
  {path:'participante',component:ParticipanteComponent,children:[
    {path:'nuevo',component:ParticipanteEditComponent},
    {path:'participante/misequipos',component:ParticipanteEditComponent},
    {path:'participante/equiposrecomendados',component:ParticipanteEditComponent}
  ]},
  {path:'alquiler',component:ParticipanteComponent},
    {path:'alquiler/nuevo',component:ParticipanteEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
