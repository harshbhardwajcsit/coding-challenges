import { TestBed, inject } from '@angular/core/testing';

import { GetTimeStampService } from './get-time-stamp.service';

describe('GetTimeStampService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetTimeStampService]
    });
  });

  it('should be created', inject([GetTimeStampService], (service: GetTimeStampService) => {
    expect(service).toBeTruthy();
  }));
});
