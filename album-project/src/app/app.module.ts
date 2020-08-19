import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AlbumBannerComponent } from './album-banner/album-banner.component';
import { AlbumListComponent } from './album-list/album-list.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AlbumServiceService } from './services/album-service.service';

@NgModule({
  declarations: [
    AppComponent,
    AlbumBannerComponent,
    AlbumListComponent,
    AboutUsComponent
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [AlbumServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
