import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AlbumBannerComponent } from './album-banner/album-banner.component';
import { AlbumListComponent } from './album-list/album-list.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AlbumServiceService } from './services/album-service.service';
import { LoginComponent } from './login/login.component';
import { AuthenticationService } from './services/authentication.service';

@NgModule({
  declarations: [
    AppComponent,
    AlbumBannerComponent,
    AlbumListComponent,
    AboutUsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [AlbumServiceService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
