import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipoEdicionComponent } from './equipo-edicion.component';

describe('EquipoEdicionComponent', () => {
  let component: EquipoEdicionComponent;
  let fixture: ComponentFixture<EquipoEdicionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipoEdicionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipoEdicionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
