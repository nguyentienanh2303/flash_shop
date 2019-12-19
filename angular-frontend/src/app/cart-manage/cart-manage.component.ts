import { Component, OnInit } from '@angular/core';
import {Cart} from './../models/cart.model';
import {Router} from '@angular/router'
import {CartService}from './../services/cart.service';
@Component({
  selector: 'app-cart-manage',
  templateUrl: './cart-manage.component.html',
  styleUrls: ['./cart-manage.component.css']
})
export class CartManageComponent implements OnInit {
  public carts: Cart[];
  public cartDetail= new Cart;
  public showCartDetail=false;
  constructor(public cartService: CartService,
              public routerService:Router,) { }

  ngOnInit() {
  	this.loadData();
  	}

  loadData(){

             this.cartService.getCartPayed().then(data=>{
             this.carts=Object(data);
             this.carts.reverse();
             })
            .catch(err=>console.log(err));
}

  OnUpdateStatus(item: Cart){

  	this.cartService.updateCart(item).then(date=>{
  			this.loadData();
  	})
  }
   
  OnDelete(idItem: number){
  	this.cartService.deleteCart(idItem).then(date=>{
  		this.loadData();
  	})
  }

  OnDetail(item: Cart){
      this.cartDetail=item
      this.showCartDetail=true;
  }

}
