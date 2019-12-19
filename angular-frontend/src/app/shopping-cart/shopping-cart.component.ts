import { Component, OnInit } from '@angular/core';
import {ProductCart} from './../models/product-cart';
import {User}from './../models/user';
import {CartService} from './../services/cart.service';
import {Product} from './../models/product.model';
import {SecurityService} from './../services/security.service';
import {Router} from '@angular/router';
import {ShareDateService} from './../services/share-date.service'
@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
 public user: User;
 public productCarts: ProductCart[];
 public totalMoney: number=0;
 public loadedUser=false;
 public payed:boolean|null;
 public loading=true;
 
  constructor(public cartService: CartService,
              public routerService: Router,
              public securityService: SecurityService,
              public shareDateService: ShareDateService) { }

  ngOnInit() {

    if(!this.securityService.checkLogged()) {

      if(confirm('bạn chưa đăng nhập, bạn có muốn đăng nhập')) this.routerService.navigate(['/login'])
        else this.routerService.navigate([''])
    }
    else
  	this.loadDate()
    this.cartService.getAdressUser().then(date=>{
      this.user=Object(date);
      this.loadedUser=true;
    })
  }
  loadDate(){
  	this.cartService.getAlLCardProduct().then(date =>{
          this.productCarts= Object(date);
          this.tinhtien();
          this.shareDateService.updateCountProduct();
  	})
  	.catch(err=>console.log(err))
  }

  tinhtien(){
  	this.totalMoney=0;
  	for(var i=0;i< this.productCarts.length;i++){
           this.totalMoney=this.totalMoney+this.productCarts[i].product.price*this.productCarts[i].amount;
  }
}
updateAmount(item){
	this.cartService.updateAmountCardProduct(item).then(()=>{
          this.shareDateService.updateCountProduct();
          
    });
	this.tinhtien()
  }
  onDelete(id){
      this.cartService.deleteCardProduct(id)

     .then(()=>this.loadDate())
      .catch(err=>console.log(err))
  }


  thanhtoan(){
      
     this.loading=true;
     if(this.loadedUser==true){
         this.cartService.pay(this.user)
         .then(date=>{
           this.loading=false
           if(Object(date)==true){
            this.loadDate();
            this.payed=true;

           }
           else this.payed=false;
       })
         .catch(()=>{this.payed=false;this.loading=false})

       
     }
  }
 
}