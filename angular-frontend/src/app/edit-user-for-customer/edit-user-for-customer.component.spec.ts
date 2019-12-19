import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditUserForCustomerComponent } from './edit-user-for-customer.component';

describe('EditUserForCustomerComponent', () => {
  let component: EditUserForCustomerComponent;
  let fixture: ComponentFixture<EditUserForCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditUserForCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditUserForCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
