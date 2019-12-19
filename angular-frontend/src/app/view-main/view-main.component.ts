import { Component, OnInit } from '@angular/core';
import {Product} from './../models/product.model';
import {ProductService}from './../services/product.service';
@Component({
  selector: 'app-view-main',
  templateUrl: './view-main.component.html',
  styleUrls: ['./view-main.component.css']
})
export class ViewMainComponent implements OnInit {
  public ssdProducts: Product;
  public ramProducts: Product;
  public cpuProducts: Product;
  public allProducts: Product[];
  
  constructor(public productService: ProductService) { }

  ngOnInit() {
  	this.loadData();
  }
loadData(){
	this.productService.getTopProductByType(4,'SSD').then(data=>{
      this.ssdProducts=Object(data);
    });
    this.productService.getTopProductByType(4,'RAM').then(data=>{
      this.ramProducts=Object(data);
    });
    this.productService.getTopProductByType(4,'CPU').then(data=>{
      this.cpuProducts=Object(data);
    });
    this.allProducts=[this.ssdProducts,this.ramProducts,this.cpuProducts];
}
}
