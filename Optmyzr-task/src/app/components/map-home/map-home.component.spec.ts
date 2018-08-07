import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MapHomeComponent } from './map-home.component';

describe('MapHomeComponent', () => {
  let component: MapHomeComponent;
  let fixture: ComponentFixture<MapHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MapHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MapHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
