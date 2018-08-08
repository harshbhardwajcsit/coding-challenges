import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {ApplicationUrlService} from "../applicationUrlService/application-url.service";

@Injectable()
export class GetDateAndTimeService {

  constructor(private http:HttpClient,private appUrlService:ApplicationUrlService) { }

  getTimeZone(geoCoordinates):Observable<any>{
    return this.http.get(this.appUrlService.googleTimeZoneApiBaseUrl+"location="+geoCoordinates.lat+"," +geoCoordinates.lng + "&timestamp=1331161200&key=AIzaSyAIa3yZTOXXlknH_2VGoPKLe_cE3GVMjoU\n");
  }




}
