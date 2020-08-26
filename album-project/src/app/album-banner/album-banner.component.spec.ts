import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumBannerComponent } from './album-banner.component';

describe('AlbumBannerComponent', () => {
  let component: AlbumBannerComponent;
  let fixture: ComponentFixture<AlbumBannerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlbumBannerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
