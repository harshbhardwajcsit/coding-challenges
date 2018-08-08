import { Injectable } from '@angular/core';

@Injectable()
export class ApplicationUrlService {

  public weatherInfoApiBaseUrl="http://api.openweathermap.org/data/2.5/weather?";
  public googleTimeZoneApiBaseUrl="";
  constructor() { }

}
