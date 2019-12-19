import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {SecurityService} from './../services/security.service';
import {ShareDateService} from './../services/share-date.service'
import {CartService}from './../services/cart.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
 public userId:number=null;
 public logged=false;
 public userName:string;
 public keySearch: string="";
 public countProduct: number|null;
  constructor(public routerService: Router,
              public securityService: SecurityService,
              public shareDateService: ShareDateService,
              public cartService: CartService) {
 
     if (localStorage.userId!=null){
         this.login();
         this.updateCount();
     }
   }

  ngOnInit() {
    this.shareDateService.currentMessage.subscribe(userName => {
        if(!(userName==="chưa đăng nhập")){
              this.login();
        }
    })


    this.shareDateService.currentCount.subscribe(isCount => {
        if(isCount==true){
             this.updateCount();
        }
    })
  
 
  }
logout(){
  this.logged=false;
	localStorage.removeItem("userId");
  localStorage.removeItem("userName");
  this.userId=null;
  this.updateCount();

}
login(){
  this.logged=true;
  this.userName=localStorage.userName;
  this.userId=localStorage.userId;
  this.updateCount();

}
goCart(){
  if(this.securityService.checkLogged())
    this.routerService.navigate(['/shopping-cart'])
  else if(confirm('bạn chưa đăng nhập, bạn có muốn đăng nhập')) this.routerService.navigate(['/login'])
}

updateCount(){
  if(this.userId==null) {this.countProduct=null; return};
 this.cartService.updateCountProduct(this.userId).then(count=>{
   this.countProduct=Object(count);
 })
}
}

