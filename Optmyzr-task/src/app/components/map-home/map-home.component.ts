import {Component, OnInit, ViewChild} from '@angular/core';
import { } from '@types/googlemaps';
import {GetUserCurrentLocationService} from '../../services/getUserCurrentLocation/get-user-current-location.service';
import {GetWeatherInfoService} from "../../services/getWeatherInfo/get-weather-info.service";

@Component({
  selector: 'app-map-home',
  templateUrl: './map-home.component.html',
  styleUrls: ['./map-home.component.css'],
  providers: [GetUserCurrentLocationService,GetWeatherInfoService]
})
export class MapHomeComponent implements OnInit {
  zoom: Number = 2.5;

  lat:any=0;
  lng:any=0;
  time:any;
  temperature:any;
  weather:any;
  previous;
  constructor(private getUserCurrentLocation: GetUserCurrentLocationService,private getWeatherInfo:GetWeatherInfoService) {

  }

  ngOnInit() {
    let geoLocationCoordinates: any = this;
    this.getUserCurrentLocation.getGeoLocationOfUser().then(function (response) {
      if(response){
        geoLocationCoordinates.lng=response.longitude;
        geoLocationCoordinates.lat=response.latitude;
      }

    },function(error){
      console.log('Error while getting Current Geological Location');
    });
  }

  mapClicked($event: any) {
    this.getWeatherInfo.getCurrentWeather($event.coords).subscribe(response=>{
      this.temperature=Math.round(this.convertKelvinToCelsius(response.main.temp));
      this.weather=response.weather[0].description;
    })
  }

  convertKelvinToCelsius(tempInKelvin){
    if (tempInKelvin >= (0)) {
      return (tempInKelvin - 273.15);
    }
  }

}





