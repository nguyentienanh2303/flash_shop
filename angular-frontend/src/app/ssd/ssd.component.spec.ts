import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SSDComponent } from './ssd.component';

describe('SSDComponent', () => {
  let component: SSDComponent;
  let fixture: ComponentFixture<SSDComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SSDComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SSDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
