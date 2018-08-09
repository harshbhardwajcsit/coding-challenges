import {Component, OnInit, ViewChild} from '@angular/core';
import { } from '@types/googlemaps';
import {GetUserCurrentLocationService} from '../../services/getUserCurrentLocation/get-user-current-location.service';
import {GetWeatherInfoService} from "../../services/getWeatherInfo/get-weather-info.service";
import {GetDateAndTimeService} from "../../services/getDateAndTime/get-date-and-time.service";
import {GetTimeStampService} from "../../services/getTimeStamp/get-time-stamp.service";

@Component({
  selector: 'app-map-home',
  templateUrl: './map-home.component.html',
  styleUrls: ['./map-home.component.css'],
  providers: [GetUserCurrentLocationService,GetWeatherInfoService,GetDateAndTimeService]
})
export class MapHomeComponent implements OnInit {
  zoom: Number = 2.3;
  lat:any=0;
  lng:any=0;
  time:any;
  standardTimeZone:any;
  localTimeZone:any;
  temperature:any;
  weather:any;
  demoMarkers:any=[];


  constructor(private getUserCurrentLocation: GetUserCurrentLocationService,
              private getWeatherInfo:GetWeatherInfoService,
              private getDateAndTimeService:GetDateAndTimeService,
              private getTimeStamp:GetTimeStampService) {

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
      let offset=response.dstOffset+response.rawOffset;
      this.time=this.calcTime(offset);
      this.standardTimeZone=this.time.toUTCString();
      this.localTimeZone=this.time.toLocaleString();

    });

    this.demoMarkers=[
      {
        lat: $event.coords.lat,
        lng: $event.coords.lng,
        label: 'o_o',
        draggable: true
      }
    ];
    console.log(this.demoMarkers);

  }

  convertKelvinToCelsius(tempInKelvin){
    if (tempInKelvin >= (0)) {
      return (tempInKelvin - 273.15);
    }
  }

  calcTime(offset) {
    var date = new Date();
    var utc = date.getTime() + (date.getTimezoneOffset() * 60000);
    var dateTime = new Date(utc + (1000*offset));
    return dateTime;
  }


}
interface marker {
  lat: number;
  lng: number;
  label?: string;
  draggable: boolean;
}






