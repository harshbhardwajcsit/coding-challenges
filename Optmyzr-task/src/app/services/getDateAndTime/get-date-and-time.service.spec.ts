import { TestBed, inject } from '@angular/core/testing';

import { GetDateAndTimeService } from './get-date-and-time.service';

describe('GetDateAndTimeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetDateAndTimeService]
    });
  });

  it('should be created', inject([GetDateAndTimeService], (service: GetDateAndTimeService) => {
    expect(service).toBeTruthy();
  }));
});
