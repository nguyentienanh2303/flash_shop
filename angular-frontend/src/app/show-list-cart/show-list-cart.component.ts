import { Component, OnInit } from '@angular/core';
import {Cart} from './../models/cart.model';
import {Router} from '@angular/router'
import {CartService}from './../services/cart.service';

@Component({
  selector: 'app-show-list-cart',
  templateUrl: './show-list-cart.component.html',
  styleUrls: ['./show-list-cart.component.css']
})
export class ShowListCartComponent implements OnInit {

  public carts: Cart[];
  public cartDetail= new Cart;
  public showCartDetail=false;
  constructor(public cartService: CartService,
              public routerService:Router,) { }

  ngOnInit() {
  	this.loadData();
  	}

  loadData(){
             if (localStorage.userId!=null){
	             this.cartService.getCartPayedByUserId(localStorage.userId).then(data=>{
	             this.carts=Object(data);
	             })
	            .catch(err=>console.log(err));
             }
}



  OnDetail(item: Cart){
      this.cartDetail=item
      this.showCartDetail=true;
  }

}
