import { Component } from '@angular/core';


export interface SidebarType{

  icon: string;
  linkTo: string;
  label: string;
}


@Component({
  selector: 'app-sidebar',
  standalone: false,
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})

export class SidebarComponent {

  isMobile: boolean = false;

  itensNav: SidebarType[] = [

    {icon:'home',label:'Dashboard',linkTo:'/dashboard'},
    {icon: 'engineering', label:'Equipamentos', linkTo:'/equipamentos' },
    {icon: 'build', label: 'Manutenções', linkTo:'/manutencoes'},
    {icon: 'supervised_user_circle', label:'Usuários', linkTo:'/usuarios'}
  ]

  toggleMenu() {
    this.isMobile = !this.isMobile;
  }
}
