import { Component, OnInit } from '@angular/core';
import {UserService}from './../services/user.service';
import {User}from './../models/user';
import {FormsModule} from '@angular/forms';
import {Router,ActivatedRoute,Params} from '@angular/router'

@Component({
  selector: 'app-edit-user-for-customer',
  templateUrl: './edit-user-for-customer.component.html',
  styleUrls: ['./edit-user-for-customer.component.css']
})
export class EditUserForCustomerComponent implements OnInit {
public user: User;
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

        if (localStorage.userId==null){
          this.routerService.navigate(['']);
         }

    	this.userSevice.getUser(id).then(data=> {
    	  this.user=Object(data);
    	})
    })


  }


  onEditUser(){
  	 this.userSevice.updateUser(this.user)
  	 .then(data=>{
  	 	if(data &&Object(data).id){
  	 		this.routerService.navigate(['']);
  	 	}
  	 })
  }

}
