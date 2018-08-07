import { TestBed, inject } from '@angular/core/testing';

import { ApplicationUrlService } from './application-url.service';

describe('ApplicationUrlService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApplicationUrlService]
    });
  });

  it('should be created', inject([ApplicationUrlService], (service: ApplicationUrlService) => {
    expect(service).toBeTruthy();
  }));
});
