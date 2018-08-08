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

  lat:any=0;
  lng:any=0;

  // initial center position for the map
  // lat = 51.673858;
  // lng = 7.815982;


  constructor(private getUserCurrentLocation: GetUserCurrentLocationService) {

  }

  ngOnInit() {
    let self: any = this;
    this.getUserCurrentLocation.getGeoLocationOfUser().then(function (response) {
      console.log("geo",response);
      if(response){
        self.lng=response.longitude;
        self.lat=response.latitude;

      }

    });
  }

  ngOnChanges(){

  }

  mapClicked($event: any) {
    console.log('lat' , $event.coords.lat);
    console.log('long' , $event.coords.lng);
  }
}





