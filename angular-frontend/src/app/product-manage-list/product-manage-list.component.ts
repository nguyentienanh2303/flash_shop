import { Component, OnInit } from '@angular/core';
import {ProductService}from './../services/product.service';
import {Product}from './../models/product.model';
import {Router} from '@angular/router'


@Component({
  selector: 'app-product-manage-list',
  templateUrl: './product-manage-list.component.html',
  styleUrls: ['./product-manage-list.component.css']
})
export class ProductManageListComponent implements OnInit {
  public products: Product[];
  constructor(public productService: ProductService,
              public routerService:Router,
    ) { }
  
  ngOnInit() {
  	this.loadData();
  	}

  loadData(){

             this.productService.getAllProduct().then(data=>{
             this.products=Object(data);
             })
            .catch(err=>console.log(err));
}


 onDelete(id : number){
     this.productService.deleteProduct(id).then(data=>{
       let index: number=this.products.findIndex(product => product.id==id);
       this.products.splice(index,1);
     })
  }
  filter(type: string){
    this.productService.getAllProductByType(type).then(data=>{
      this.products=Object(data);
    })
   .catch(err=>console.log(err))
  }

 onLogout(){
   localStorage.removeItem('logged');
    this.routerService.navigate(['/login-admin']);
 }


}
 