import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorHomeComponent } from './editor-home.component';

describe('EditorHomeComponent', () => {
  let component: EditorHomeComponent;
  let fixture: ComponentFixture<EditorHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditorHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
