import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CanchaEdicionComponent } from './cancha-edicion.component';

describe('CanchaEdicionComponent', () => {
  let component: CanchaEdicionComponent;
  let fixture: ComponentFixture<CanchaEdicionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CanchaEdicionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CanchaEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
