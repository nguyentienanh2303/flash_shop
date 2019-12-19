import { Component, OnInit } from '@angular/core';
import {Product} from './../models/product.model';
import {ProductService}from './../services/product.service';
@Component({
  selector: 'app-ssd',
  templateUrl: './ssd.component.html',
  styleUrls: ['./ssd.component.css']
})
export class SSDComponent implements OnInit {
  bansao=[1,2,3,4];
  public products: Product[];
  constructor(public productService: ProductService) { }

  ngOnInit() {
  	this.loadData();
  }

loadData(){
   this.productService.getAllProductByType('SSD').then(data=>{
      this.products=Object(data);
    })
   .catch(err=>console.log(err))
}

}