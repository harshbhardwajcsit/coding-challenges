import { Injectable } from '@angular/core';

@Injectable()
export class ApplicationUrlService {

  public weatherInfoApiBaseUrl="http://api.openweathermap.org/data/2.5/weather?";
  public googleTimeZoneApiBaseUrl="https://maps.googleapis.com/maps/api/timezone/json?";
  public weatherApiKey="YOUR_WEATHER_API_KEY";
  public googleMapKey="YOUR_GOOGLE_MAP_API_KEY";
  constructor() { }

}
