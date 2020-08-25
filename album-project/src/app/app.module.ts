import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AlbumBannerComponent } from './album-banner/album-banner.component';
import { AlbumListComponent } from './album-list/album-list.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AlbumServiceService } from './services/album-service.service';
import { HttpClientModule } from '@angular/common/http';
import { UserCartComponent } from './user-cart/user-cart.component';
import { UserAccessComponent } from './user-access/user-access.component';

@NgModule({
  declarations: [
    AppComponent,
    AlbumBannerComponent,
    AlbumListComponent,
    AboutUsComponent,
    UserCartComponent,
    UserAccessComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AlbumServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
