import { Component, OnInit } from '@angular/core';
import {Product} from './../models/product.model';
import {ProductService}from './../services/product.service';
import {Router,ActivatedRoute,Params} from '@angular/router'
@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css']
})
export class SearchProductComponent implements OnInit {
 public resultSearch: Product[];
 public filterKey: String[];
 public Key: String="";

  constructor(public routerService: Router,
              public activatedRouteService: ActivatedRoute,
              public productService: ProductService) { }

  ngOnInit() {
    this.activatedRouteService.params.subscribe(data=>{
      let keySearch:string
      if(data.keySearch==null) keySearch=null
      else
      {
        this.Key=data.keySearch;
        this.onSearch();
      }
    })


  }
 
 onSearch(){
    if(this.Key!=""){
 	this.filterKey=this.Key.split(" ");
 	this.productService.searchProduct(this.filterKey).then(date=>{
 		this.resultSearch=Object(date);
 	    });
    }
}

goEnter(event){
    if (event.keyCode === 13) {
    	this.onSearch();
  }
}


}
