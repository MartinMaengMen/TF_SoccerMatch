import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { UsuarioEdicionComponent } from './pages/usuario/usuario-edicion/usuario-edicion.component';
import { EquipoComponent } from './pages/equipo/equipo.component';
import { CanchaComponent } from './pages/cancha/cancha.component';
import { EquipoEdicionComponent } from './pages/equipo/equipo-edicion/equipo-edicion.component';
import { CanchaEdicionComponent } from './pages/cancha/cancha-edicion/cancha-edicion.component';
import { ParticipanteComponent } from './pages/participante/participante.component';
import { ParticipanteEditComponent } from './pages/participante/participante-edit/participante-edit.component';
import { MisequiposComponent } from './pages/equipo/misequipos/misequipos.component';
import { RecomendadosComponent } from './pages/equipo/recomendados/recomendados.component';
import { DetalleequipoComponent } from './pages/equipo/detalleequipo/detalleequipo.component';
import { MisequiposEdicionComponent } from './pages/equipo/misequipos/misequipos-edicion/misequipos-edicion.component';
import { AlquilerComponent } from './pages/alquiler/alquiler.component';
import { AlquilerEdicionComponent } from './pages/alquiler/alquiler-edicion/alquiler-edicion.component';
<<<<<<< HEAD
import { nuevoequipo } from './pages/equipo/nuevoequipo/nuevoequipo.component';
=======
import { DetallemisequiposComponent } from './pages/equipo/detallemisequipos/detallemisequipos.component';
>>>>>>> 26bd4da168b8796b4c0c9a196160870df7a6b659

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    UsuarioEdicionComponent,
    EquipoComponent,
    CanchaComponent,
    EquipoEdicionComponent,
    CanchaEdicionComponent,
    ParticipanteComponent,
    ParticipanteEditComponent,
    MisequiposComponent,
    RecomendadosComponent,
    DetalleequipoComponent,
    MisequiposEdicionComponent,
    AlquilerComponent,
    AlquilerEdicionComponent,
<<<<<<< HEAD
    nuevoequipo
=======
    DetallemisequiposComponent
>>>>>>> 26bd4da168b8796b4c0c9a196160870df7a6b659
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
