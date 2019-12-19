import { Component, OnInit } from '@angular/core';
import {UserService}from './../services/user.service';
import {User}from './../models/user';
import {FormsModule} from '@angular/forms';
import {Router,ActivatedRoute,Params} from '@angular/router'
@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
public user: User;
public nextLink="admin/user-manage";
  constructor(public userSevice: UserService, 
  	          public routerService: Router,
  	          public activatedRouteService: ActivatedRoute
  	          ) { }

  ngOnInit() {
  	this.user= new User;
  	this.loaData()
  	
  }

  loaData(){
    this.activatedRouteService.params.subscribe(data=>{
    	let id=data.id;
      // let isUser=data.user;
      // if(isUser==="user") {
      //   this.nextLink='';
      //   if (localStorage.userId==null){
      //     this.routerService.navigate([this.nextLink]);
      //    }
      //  }

    	this.userSevice.getUser(id).then(data=> {
    	  this.user=Object(data);
    	})
    })


  }


  onEditUser(){
  	 this.userSevice.updateUser(this.user)
  	 .then(data=>{
  	 	if(data &&Object(data).id){
  	 		this.routerService.navigate([this.nextLink]);
  	 	}
  	 })
  }


  

}
