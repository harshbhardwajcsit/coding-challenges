import {Component, OnInit, ViewChild} from '@angular/core';
import { } from '@types/googlemaps';
import {GetUserCurrentLocationService} from '../../services/getUserCurrentLocation/get-user-current-location.service';
import {GetWeatherInfoService} from "../../services/getWeatherInfo/get-weather-info.service";
import {GetDateAndTimeService} from "../../services/getDateAndTime/get-date-and-time.service";

@Component({
  selector: 'app-map-home',
  templateUrl: './map-home.component.html',
  styleUrls: ['./map-home.component.css'],
  providers: [GetUserCurrentLocationService,GetWeatherInfoService,GetDateAndTimeService]
})
export class MapHomeComponent implements OnInit {
  zoom: Number = 2.5;

  lat:any=0;
  lng:any=0;
  time:any;
  temperature:any;
  weather:any;
  previous;
  constructor(private getUserCurrentLocation: GetUserCurrentLocationService,private getWeatherInfo:GetWeatherInfoService,private getDateAndTimeService:GetDateAndTimeService) {

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
    });

    this.getDateAndTimeService.getTimeZone($event.coords).subscribe(response=>{
      console.log("time",response);
    });

    console.log(this.getTimeStamp());


  }

  convertKelvinToCelsius(tempInKelvin){
    if (tempInKelvin >= (0)) {
      return (tempInKelvin - 273.15);
    }
  }

  getTimeStamp() {
    let now = new Date();
    console.log(now)
    return ((now.getMonth() + 1) + '/' + (now.getDate()) + '/' + now.getFullYear() + " " + now.getHours() + ':'
      + ((now.getMinutes() < 10) ? ("0" + now.getMinutes()) : (now.getMinutes())) + ':' + ((now.getSeconds() < 10) ? ("0" + now
        .getSeconds()) : (now.getSeconds())));
  }

}





