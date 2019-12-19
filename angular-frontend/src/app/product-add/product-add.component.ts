import { Component, OnInit } from '@angular/core';
import {ProductService}from './../services/product.service';
import {Product}from './../models/product.model';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router'
@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  public product: Product;
  constructor(public productSevice: ProductService, 
  	          public routerService: Router) { }

  ngOnInit() {
  	this.product= new Product;
    this.product.type=null;
  }
  onAddProduct(){
  	 this.productSevice.addProduct(this.product)
  	 .then(data=>{
  	 	if(data &&Object(data).id){
  	 		this.routerService.navigate(['admin/productmanage']);
  	 	}
  	 })
  }

  
  
}