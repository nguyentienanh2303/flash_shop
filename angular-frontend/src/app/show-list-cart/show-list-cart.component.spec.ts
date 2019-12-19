import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowListCartComponent } from './show-list-cart.component';

describe('ShowListCartComponent', () => {
  let component: ShowListCartComponent;
  let fixture: ComponentFixture<ShowListCartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowListCartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowListCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
