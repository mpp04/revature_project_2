import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AlbumBannerComponent } from './album-banner/album-banner.component';
import { AlbumListComponent } from './album-list/album-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AlbumBannerComponent,
    AlbumListComponent
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
