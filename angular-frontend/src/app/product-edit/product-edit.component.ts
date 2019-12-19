import { Component, OnInit } from '@angular/core';
import {ProductService}from './../services/product.service';
import {Product}from './../models/product.model';
import {FormsModule} from '@angular/forms';
import {Router,ActivatedRoute,Params} from '@angular/router'

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
 
 public product: Product;
  constructor(public productSevice: ProductService, 
  	          public routerService: Router,
  	          public activatedRouteService: ActivatedRoute
  	          ) { }

  ngOnInit() {
  	this.product= new Product;
  	this.loaData()
  	
  }

  loaData(){
    this.activatedRouteService.params.subscribe(data=>{
    	let id=data.id;
    	this.productSevice.getProduct(id).then(data=> {
    	  this.product=Object(data);
    	})
    })
  }



  onEditProduct(){
  	 this.productSevice.updateProduct(this.product)
  	 .then(data=>{
  	 	if(data &&Object(data).id){
  	 		this.routerService.navigate(['admin/productmanage']);
  	 	}
  	 })
  }

  

}
