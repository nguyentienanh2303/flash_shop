import { Component, OnInit } from '@angular/core';
import {Product} from './../models/product.model';
import {ProductService}from './../services/product.service';
@Component({
  selector: 'app-cpu',
  templateUrl: './cpu.component.html',
  styleUrls: ['./cpu.component.css']
})
export class CPUComponent implements OnInit {
  bansao=[1,2,3,4];
  public products: Product[];
  constructor(public productService: ProductService) { }

  ngOnInit() {
  	this.loadData();
  }

loadData(){
   this.productService.getAllProductByType('CPU').then(data=>{
      this.products=Object(data);
    })
   .catch(err=>console.log(err))
}
}
