import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ProductCart} from './../models/product-cart';
import {User}from './../models/user';
import {Cart} from './../models/cart.model';
@Injectable({
  providedIn: 'root'
})
export class CartService {
  
  public productCarts: ProductCart[];
  public API: string='http://localhost:1415/cartproduct';

  constructor(public http: HttpClient) { }

  getAlLCardProduct(){
  	return this.http.get(this.API+'/user/'+localStorage.userId).toPromise() //lấy tất cả sản phẩm
  }
  updateAmountCardProduct(productCart){
  	return this.http.put(this.API+'/'+productCart.id,productCart).toPromise() //cập nhật số lượng
  }

  deleteCardProduct(id: number){
       return this.http.delete(this.API+'/'+id).toPromise()
  }
  
  addCardProduct(productId: Number){
          return this.http.post('http://localhost:1415/advancecartproduct?productId='+productId+'&&userId='+localStorage.userId,null).toPromise()
}

  getAdressUser(){
    return this.http.get('http://localhost:1415/userAdress/'+localStorage.userId).toPromise()
  }
  pay(user: User){
     return this.http.post('http://localhost:1415/pay/user',user).toPromise()
  }

  getCartPayed(){
    return this.http.get('http://localhost:1415/cartPayed').toPromise()
  }

   getCartPayedByUserId(userId:number){
    return this.http.get('http://localhost:1415/cartPayed/'+userId).toPromise()
  }
   
  deleteCart(id: number){
    return this.http.delete("http://localhost:1415/cart/"+id).toPromise()
  }

  updateCart(cart: Cart){
     return this.http.put('http://localhost:1415/cart/'+cart.id,cart).toPromise()
  }

  updateCountProduct(userId){
    return this.http.get('http://localhost:1415/countProduct/user/'+userId).toPromise()
  }
}
