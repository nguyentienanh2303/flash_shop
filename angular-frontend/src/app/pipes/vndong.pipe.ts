import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'VNDONG',
})

export class VNDONG implements PipeTransform{
    transform(price: number) : string{
    	 
    	  var priceString= price.toString();
    	  var priceStrings = new Array();
        for (let i=0;i<priceString.length ;i++){
        	priceStrings.push(priceString[i])
        }
    	 var socham = ((priceString.length-1)/3);
    	for (let i=1;i<=socham ;i++){
    	     priceStrings.splice((priceString.length-3*i),0,'.')
    	};
    	priceString='';
    	 for (let i=0;i<priceStrings.length ;i++){
        	priceString=priceString+priceStrings[i];
        }
    	return    priceString
    }
}