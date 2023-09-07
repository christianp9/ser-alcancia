import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonedalistingComponent } from './monedalisting.component';

describe('AssociatelistingComponent', () => {
  let component: MonedalistingComponent;
  let fixture: ComponentFixture<MonedalistingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MonedalistingComponent]
    });
    fixture = TestBed.createComponent(MonedalistingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
