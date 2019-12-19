import { Pipe, PipeTransform } from '@angular/core';
import {Cart} from './../models/cart.model';
import {Product} from './../models/product.model';
import {ProductCart} from './../models/product-cart';
@Pipe({
    name: 'CARTMONEY',
})

export class CARTMONEY implements PipeTransform{
    transform(cart: Cart) : number{
    	 
    	  var totalMoney : number=0;
          for(var item  of cart.listCartProduct){
                totalMoney=totalMoney+ item.product.price;
          }
    	return    totalMoney
    }
}