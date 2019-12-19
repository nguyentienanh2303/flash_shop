import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from './../models/product.model'
@Injectable({
  providedIn: 'root'
})
export class ProductService {
   
  public API: string='http://localhost:1415/product';
  constructor(public http: HttpClient) { }

  getAllProduct(){
  	return this.http.get(this.API).toPromise() //lấy tất cả sản phẩm
  }
  getAllProductByType(type:string){
    return this.http.get(this.API+'?type='+type).toPromise()  //lấy sản phẩm theo loại
  }
  addProduct(product: Product){
  	return this.http.post(this.API,product).toPromise()         //thêm 1 sản phẩm
  }

  updateProduct(product : Product){
  	return this.http.put(this.API+'/'+product.id,product).toPromise()    //cập nhật 1 sản phẩm
  }

  deleteProduct(id : number){
  	return this.http.delete(this.API+'/'+id).toPromise()                 //xóa 1 sản phẩm
  }
  
  getProduct(id: number){ 
        return this.http.get(this.API+'/'+id).toPromise()                 //lấy ra 1 sản phẩm
  }
  getTopProductByType(top:number, type: string){
    return this.http.get(this.API+'?type='+type+'&limit='+top).toPromise()   //lấy top m sản phẩm đầu tiên

  }

  searchProduct(keys){
    return this.http.post(this.API+'/search',keys).toPromise()
  }
} 
