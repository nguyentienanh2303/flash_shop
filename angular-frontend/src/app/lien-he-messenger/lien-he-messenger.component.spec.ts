import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LienHeMessengerComponent } from './lien-he-messenger.component';

describe('LienHeMessengerComponent', () => {
  let component: LienHeMessengerComponent;
  let fixture: ComponentFixture<LienHeMessengerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LienHeMessengerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LienHeMessengerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
