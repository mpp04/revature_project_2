import { Component, OnInit } from '@angular/core';
import { Album } from '../models/Album';

@Component({
  selector: 'app-album-banner',
  templateUrl: './album-banner.component.html',
  styleUrls: ['./album-banner.component.css']
})
export class AlbumBannerComponent implements OnInit {

  cart: Album[];

  constructor() { }

  ngOnInit(): void {
  }

}
