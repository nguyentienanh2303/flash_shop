import { Component, OnInit, Input } from '@angular/core';
import {ActivatedRoute,Params} from '@angular/router';
import {ProductService}from './../services/product.service';
import {CartService}from './../services/cart.service';
import {Product}from './../models/product.model';
import {SecurityService} from './../services/security.service';
import {Router} from '@angular/router';
import {ShareDateService} from './../services/share-date.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],

})
export class ProductDetailComponent implements OnInit {
 // public convertsummary= new Array;
 public product: Product;
 public complete=false;

  constructor(public productSevice: ProductService, 
              public cartService: CartService,
              public routerService: Router,
  	          public activatedRouteService: ActivatedRoute,
              public securityService: SecurityService,
              public shareDateService: ShareDateService
  	          ) { }

  ngOnInit() {
  	this.product= new Product;
    this.product.price=0;     /*phải khởi tạo vì loadDate lấy dữ liệu từ server
                                 nên chậm mà file html lại load trước khi lấy 
                                dữ liệu, thời điểm html load thì vẫn chưa có bộ nhớ dành cho các biến
                                nên nó sẽ bị lỗi ko có các thuộc tính vì biến lúc chưa load ko rõ kiểu dũ liệu
                                và là underfound*/
    this.product.summary='';
  	this.loaData();
 
  }
  
  loaData(){
    this.activatedRouteService.params.subscribe(data=>{
    	let id=data.id;
    	this.productSevice.getProduct(id).then(product=> {
    	  this.product=Object(product);
    	})
    });
  }




  addToCart(productId: Number){
   if(this.securityService.checkLogged()){
    this.cartService.addCardProduct(productId).then(()=>{
          this.shareDateService.updateCountProduct();
          this.complete=true
          this.delay(1000).then(()=>this.complete=false)
          
    })

     
  }
  else if(confirm('bạn chưa đăng nhập, bạn có muốn đăng nhập')) this.routerService.navigate(['/login'])
       

  }

   delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
}
  


}