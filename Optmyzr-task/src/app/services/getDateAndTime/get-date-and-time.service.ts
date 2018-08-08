import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {ApplicationUrlService} from "../applicationUrlService/application-url.service";
import {GetTimeStampService} from "../getTimeStamp/get-time-stamp.service";

@Injectable()
export class GetDateAndTimeService {

  constructor(private http:HttpClient,
              private appUrlService:ApplicationUrlService,
              private getTimeStamp:GetTimeStampService) { }

  getTimeZone(geoCoordinates):Observable<any>{
    return this.http.get(this.appUrlService.googleTimeZoneApiBaseUrl+"location="+geoCoordinates.lat+"," +geoCoordinates.lng + "&timestamp=" +this.getTimeStamp.getTimeStamp() +"&key=" + this.appUrlService.googleMapKey);
  }




}
