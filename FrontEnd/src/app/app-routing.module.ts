import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { UsuarioEdicionComponent } from './pages/usuario/usuario-edicion/usuario-edicion.component';

const routes: Routes = [
  {path:'usuario',component:UsuarioComponent,children:[
    {path:'nuevo',component:UsuarioEdicionComponent},
    {path:'edicion/:id',component:UsuarioEdicionComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
