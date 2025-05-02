import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BaseUiComponent } from './components/base-ui/base-ui.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { MatIconModule } from '@angular/material/icon';
import { EquipamentosComponent } from './pages/equipamentos/equipamentos.component';
import { ManutencoesComponent } from './pages/manutencoes/manutencoes.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { MeuPerfilComponent } from './pages/meu-perfil/meu-perfil.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    BaseUiComponent,
    SidebarComponent,
    EquipamentosComponent,
    ManutencoesComponent,
    UsuariosComponent,
    MeuPerfilComponent,
    DashboardComponent  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
