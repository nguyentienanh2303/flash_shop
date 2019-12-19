import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

public API: string='http://localhost:1415/user';
  constructor(public http: HttpClient) { }

  getAllUser(){
  	return this.http.get(this.API).toPromise() //lấy tất cả sản phẩm
  }
  getAllUserByType(type:string){
    return this.http.get(this.API+'?type='+type).toPromise()  //lấy sản phẩm theo loại
  }
  addUser(User: User){
  	return this.http.post(this.API,User).toPromise()         //thêm 1 sản phẩm
  }

  updateUser(User : User){
  	return this.http.put(this.API+'/'+User.id,User).toPromise()    //cập nhật 1 sản phẩm
  }

  deleteUser(id : number){
  	return this.http.delete(this.API+'/'+id).toPromise()                 //xóa 1 sản phẩm
  }
  
  getUser(id: number){ 
        return this.http.get(this.API+'/'+id).toPromise()                 //lấy ra 1 sản phẩm
  }
  getTopUserByType(top:number, type: string){
    return this.http.get(this.API+'?type='+type+'&limit='+top).toPromise()   //lấy top m sản phẩm đầu tiên

  }
}
