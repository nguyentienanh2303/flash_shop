import { Component, OnInit, Input } from '@angular/core';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
 @Input() linkImg:string;
 @Input() name:string;
 @Input() summary:string;
 @Input() price:string;
 @Input() id:string;



  constructor() {
    
   }

  ngOnInit() {
  
  }

}
