import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class GetUserCurrentLocationService {


  constructor() { }


    getGeoLocationOfUser(): any {
     if (navigator.geolocation) {
       return new Promise(function (resolve,reject) {
         navigator.geolocation.getCurrentPosition(function(response) {
             if(response){
               resolve(response.coords);
             }
           }, function(err) {
               reject(err);
             alert('Unable to get GPS Location');
           }, {
             enableHighAccuracy : true
           });
       })
     } else {
       alert('Geolocation is not supported by this browser');
     }

  }
}
