import { TestBed, inject } from '@angular/core/testing';

import { CanvasActionService } from './canvas-action.service';

describe('CanvasActionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CanvasActionService]
    });
  });

  it('should be created', inject([CanvasActionService], (service: CanvasActionService) => {
    expect(service).toBeTruthy();
  }));
});
