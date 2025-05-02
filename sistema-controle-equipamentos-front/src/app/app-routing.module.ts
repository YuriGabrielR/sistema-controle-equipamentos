import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { MeuPerfilComponent } from './pages/meu-perfil/meu-perfil.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { ManutencoesComponent } from './pages/manutencoes/manutencoes.component';
import { EquipamentosComponent } from './pages/equipamentos/equipamentos.component';

const routes: Routes = [
  {path:'dashboard', component:DashboardComponent},
  {path:'equipamentos', component:EquipamentosComponent},
  {path:'manutencoes', component:ManutencoesComponent},
  {path:'usuarios', component:UsuariosComponent},
  {path:'meu-perfil', component:MeuPerfilComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
