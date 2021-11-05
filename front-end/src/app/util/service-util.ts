
import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root'
  })

export class ServiceUtil {

    public getJsonHeader(): any{
        return {
            'Content-type': 'application/json',
            "Authorization": 'Bearer '.concat(sessionStorage.getItem('token')|| '{}')
        };
    }

   public getSimpleHeader(): any{
       console.log(sessionStorage.getItem('token'));
        return  {
            "Authorization": 'Bearer '.concat(sessionStorage.getItem('token')|| '{}')
        }
    }
}
