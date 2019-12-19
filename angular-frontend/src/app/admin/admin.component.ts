import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(public routerService:Router,) { }

  ngOnInit() {
  	  let checklogged= localStorage.AdminLogged;
      if(!(checklogged==='true'))
      this.routerService.navigate(['/login-admin']);
  }

 onLogout(){
   localStorage.removeItem('AdminLogged');
    this.routerService.navigate(['/login-admin']);
 }
}
