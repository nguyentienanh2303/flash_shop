import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShareDateService {
   private countProduct = new BehaviorSubject(false);
   private userName = new BehaviorSubject('chưa đăng nhập');
  currentMessage = this.userName.asObservable();
  currentCount = this.countProduct.asObservable();

  constructor() { }
   changeMessage(Name: string) {
    this.userName.next(Name)
  }

   updateCountProduct(){
    this.countProduct.next(true)
   }

}
