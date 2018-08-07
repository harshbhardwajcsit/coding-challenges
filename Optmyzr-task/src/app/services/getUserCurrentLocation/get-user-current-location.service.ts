import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class GetUserCurrentLocationService {

  constructor() { }

    getGeoLocationOfUser(): any {
    let geoLocationCoordinates = null;
     if (navigator.geolocation) {
       navigator.geolocation.getCurrentPosition(function(response) {
         geoLocationCoordinates = response.coords;
         console.log(response.coords);
       }, function() {
         alert('Unable to get GPS Location');
       }, {
         enableHighAccuracy : true
       });
     } else {
       alert('Geolocation is not supported by this browser');
     }
      return geoLocationCoordinates;
  }
}
