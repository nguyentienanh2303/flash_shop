import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  email='';
  password='';
  checkUser
 
  constructor( public routerService: Router) { }

  ngOnInit() {
    let checklogged= localStorage.AdminLogged;
      if(checklogged=='true')
      this.routerService.navigate(['admin']);

    }
  
  
  onSubmit(formSignIn){
    if((this.email='manh1451999@gmail.com') && (this.password=='manh123456')){
          localStorage.setItem('AdminLogged','true');
      this.routerService.navigate(['admin'])
    } else{this.checkUser=true};

  }
}
