import { Component } from '@angular/core';
import { Router } from '@angular/router';


interface SidebarType{

  icon: String;
  linkTo: String;
  label: String;
}


@Component({
  selector: 'app-sidebar',
  standalone: false,
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})

export class SidebarComponent {

  constructor(private router: Router){}

  isActiveURL(route: string): boolean{
    return this.router.url.includes(route);

  }

  itensNav: SidebarType[] = [

    {icon:'home',label:'Dashboard',linkTo:'/dashboard'},
    {icon: 'engineering', label:'Equipamentos', linkTo:'/equipamentos' },
    {icon: 'build', label: 'Manutenções', linkTo:'/manutencoes'},
    {icon: 'supervised_user_circle', label:'Usuários', linkTo:'/usuarios'}
  ]



}
