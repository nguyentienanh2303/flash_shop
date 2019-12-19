import { Component, OnInit } from '@angular/core';
import {UserService}from './../services/user.service';
import {User}from './../models/user';
import {Router} from '@angular/router'
@Component({
  selector: 'app-user-manage',
  templateUrl: './user-manage.component.html',
  styleUrls: ['./user-manage.component.css']
})
export class UserManageComponent implements OnInit {
public users: User[];
  constructor(public userService: UserService,
              public routerService:Router,
    ) { }
  
  ngOnInit() {
  	this.loadData();
  	}

  loadData(){

             this.userService.getAllUser().then(data=>{
             this.users=Object(data);
             })
            .catch(err=>console.log(err));
}


 onDelete(id : number){
     this.userService.deleteUser(id).then(data=>{
       let index: number=this.users.findIndex(user => user.id==id);
       this.users.splice(index,1);
     })
  }
  



}
