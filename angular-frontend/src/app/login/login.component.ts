import { Component, OnInit } from '@angular/core';
import {User} from './../models/user';
import {SecurityService} from './../services/security.service';
import {Router} from '@angular/router';
import {ShareDateService} from './../services/share-date.service'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   public user: User;
   public checkUser=true;//đúng nếu  tồn tại
 
  constructor( public routerService: Router,
               public securityService: SecurityService,
               public shareDateService: ShareDateService) { }

  ngOnInit() {
    this.user = new User;
      if(this.securityService.checkLogged()) 
       this.routerService.navigate([''])
//        this.routerService.navigateByUrl('/', {skipLocationChange: true}).then(()=>
// this.routerService.navigate(['']));

    }
  

  onSubmit(formSignIn){
  	
  this.securityService.checkUserByEmailAndPassWord(this.user).then(date=>{
         this.checkUser=Boolean(date);
       if(this.checkUser){
         console.log('tài khoản hợp lệ')
         this.user.id=Number(date);
         localStorage.setItem('userId',this.user.id.toString());
         this.securityService.getUserName(localStorage.userId).then(userName=>{
             localStorage.setItem('userName',userName.toString());
             this.shareDateService.changeMessage(localStorage.userName.toString());
             })
         this.routerService.navigate([''])
       }
       else console.log('sai tài khoản hoặc mật khẩu')
       })
}

}
