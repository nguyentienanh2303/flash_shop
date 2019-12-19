import { Component, OnInit } from '@angular/core';
import {User} from './../models/user';
import {SecurityService} from './../services/security.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
   public user: User;
   public checkUser:Boolean=true;//đúng nếu chưa tồn tại
  constructor(public securityService: SecurityService,
              public routerService: Router ) { }

  ngOnInit() {
  	  this.user = new User;
  }
onSubmit(formSignUp){
       this.securityService.checkUserByEmail(this.user).then(date=>{
       	this.checkUser=Boolean(date);
       if(!this.checkUser){
       	this.securityService.SignUp(this.user).then(()=>{formSignUp.reset()})
       }
       else console.log('email đã tồn tại')
       })
}

goLogin(){
     this.routerService.navigate(['/login'])
}

}