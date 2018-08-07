import { TestBed, inject } from '@angular/core/testing';

import { GetUserCurrentLocationService } from './get-user-current-location.service';

describe('GetUserCurrentLocationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetUserCurrentLocationService]
    });
  });

  it('should be created', inject([GetUserCurrentLocationService], (service: GetUserCurrentLocationService) => {
    expect(service).toBeTruthy();
  }));
});
