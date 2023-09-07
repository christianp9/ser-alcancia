import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmonedaComponent } from './addmoneda.component';

describe('AddassociateComponent', () => {
  let component: AddmonedaComponent;
  let fixture: ComponentFixture<AddmonedaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddmonedaComponent]
    });
    fixture = TestBed.createComponent(AddmonedaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
