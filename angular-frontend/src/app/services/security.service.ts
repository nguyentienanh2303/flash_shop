import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './../models/user';
@Injectable({
  providedIn: 'root'
})
export class SecurityService {
   public API: string ='http://localhost:1415/user'

  constructor(public http: HttpClient) { }

  public checkUserByEmailAndPassWord(user: User){
         return this.http.post(this.API+'/check',user).toPromise()
  }

  public checkUserByEmail(user: User){
         return this.http.post(this.API+'/checkemail',user).toPromise()
     }
  public checkUserById(id: Number){
         return this.http.get(this.API+'/check/'+id).toPromise()
     }
   public getUserName(id: Number){
         return this.http.get(this.API+'/'+id).toPromise().then(date=>Object(date).lastName)
     }
   
   // public checkLogged(){
   //      var complet=false;
   //      let check:boolean=false
   //      if(localStorage.userId!=null){
   //        this.checkUserById(localStorage.userId).then(date=>{
   //          console.log(Boolean(date))
   //          if(Boolean(date)) check=true;
   //            else {check=false;localStorage.removeItem("userId")}
   //             complet=true;
            
   //          })
   //      }
   //      while(!complet){console.log('chạy')};
   //      console.log('đã load xong')

   //       return check
   //    }

      public checkLogged(){
          if(localStorage.userId==null) return false;
           else return true
        }
     
 

  public SignUp(user: User){
		return this.http.post(this.API, user).toPromise()
	}

}
