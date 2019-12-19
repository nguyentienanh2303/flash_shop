import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'SUMMARY',
})

export class SUMMARY implements PipeTransform{
    transform(summary: string) : any{
    	var summarys = new Array();
        var tmp='';

        for (let i=0;i<summary.length ;i++){
            let current=summary[i];
            if(current != '|' && !(current == '/' && summary[i+1]==' ')&&!(current == '.'&&summary[i+1]==' ')){

                tmp=tmp+current;
            }
            if(current == '|' || (current == '/'&&summary[i+1]==' ') ||(i==(summary.length-1))||(current == '.'&&summary[i+1]==' ')){
                summarys.push(tmp);
                tmp='';
            }
        };
        return summarys;
    }
}