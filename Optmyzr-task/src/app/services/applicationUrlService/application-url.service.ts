import { Injectable } from '@angular/core';

@Injectable()
export class ApplicationUrlService {

  public weatherInfoApiBaseUrl="https://api.openweathermap.org/data/2.5/weather?";
  public googleTimeZoneApiBaseUrl="https://maps.googleapis.com/maps/api/timezone/json?";
  public weatherApiKey="bce5fa606dea95d559f6ed26d3268d7d";
  public googleMapKey="AIzaSyAYfnEdyDBFRM-sjEDAPGdr5DRxojo_MDs";
  constructor() { }

}
