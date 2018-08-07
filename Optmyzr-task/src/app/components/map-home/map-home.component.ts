import {Component, OnInit, ViewChild} from '@angular/core';
import { } from '@types/googlemaps';
import {GetUserCurrentLocationService} from '../../services/getUserCurrentLocation/get-user-current-location.service';

@Component({
  selector: 'app-map-home',
  templateUrl: './map-home.component.html',
  styleUrls: ['./map-home.component.css'],
  providers: [GetUserCurrentLocationService]
})
export class MapHomeComponent implements OnInit {
  zoom: Number = 2.5;
  currentGeoLocation: any = null;
  lat: any;
  lng: any;

  // initial center position for the map
  // lat = 51.673858;
  // lng = 7.815982;


  constructor(private getUserCurrentLocation: GetUserCurrentLocationService) {

  }

  ngOnInit() {

       this.currentGeoLocation = this.getUserCurrentLocation.getGeoLocationOfUser();
       console.log("yes", this.currentGeoLocation);
    // this.lat = this.currentGeoLocation.latitude;
    // this.lng = this.currentGeoLocation.longitude;
  }

  mapClicked($event: any) {
    console.log('lat' , $event.coords.lat);
    console.log('long' , $event.coords.lng);
  }
}





