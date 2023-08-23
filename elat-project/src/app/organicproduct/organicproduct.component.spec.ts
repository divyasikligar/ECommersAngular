import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganicproductComponent } from './organicproduct.component';

describe('OrganicproductComponent', () => {
  let component: OrganicproductComponent;
  let fixture: ComponentFixture<OrganicproductComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrganicproductComponent]
    });
    fixture = TestBed.createComponent(OrganicproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
