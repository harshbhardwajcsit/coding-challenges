import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {ApplicationUrlService} from "../applicationUrlService/application-url.service";

@Injectable()
export class GetWeatherInfoService {

  private weatherApi:string;
  constructor(private http:HttpClient,private appUrlService:ApplicationUrlService) { }

  getCurrentWeather(geoCoordinates): Observable<any>{
    return this.http.get(this.appUrlService.weatherInfoApiBaseUrl+
      "lat=" + geoCoordinates.lat + "&lon=" + geoCoordinates.lng +"&appid="+ this.appUrlService.weatherApiKey);
  }

}
