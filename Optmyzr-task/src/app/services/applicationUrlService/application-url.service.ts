import { Injectable } from '@angular/core';

@Injectable()
export class ApplicationUrlService {

  public weatherInfoApiBaseUrl="http://api.openweathermap.org/data/2.5/weather?";
  public googleTimeZoneApiBaseUrl="https://maps.googleapis.com/maps/api/timezone/json?";
  public weatherApiKey="weather_Api_key";
  public googleMapKey="Google_map_key";
  constructor() { }

}
