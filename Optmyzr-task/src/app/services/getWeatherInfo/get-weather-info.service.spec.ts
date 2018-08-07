import { TestBed, inject } from '@angular/core/testing';

import { GetWeatherInfoService } from './get-weather-info.service';

describe('GetWeatherInfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetWeatherInfoService]
    });
  });

  it('should be created', inject([GetWeatherInfoService], (service: GetWeatherInfoService) => {
    expect(service).toBeTruthy();
  }));
});
