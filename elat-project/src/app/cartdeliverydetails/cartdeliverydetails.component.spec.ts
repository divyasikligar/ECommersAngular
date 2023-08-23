import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartdeliverydetailsComponent } from './cartdeliverydetails.component';

describe('CartdeliverydetailsComponent', () => {
  let component: CartdeliverydetailsComponent;
  let fixture: ComponentFixture<CartdeliverydetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CartdeliverydetailsComponent]
    });
    fixture = TestBed.createComponent(CartdeliverydetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
