import { Component, OnInit } from '@angular/core';
import { Album } from '../models/Album';

@Component({
  selector: 'app-album-banner',
  templateUrl: './album-banner.component.html',
  styleUrls: ['./album-banner.component.css']
})
export class AlbumBannerComponent implements OnInit {

  cart: Album[];

  constructor() {
    this.cart = []; // Needs to be initially empty to properly set up the HTML view
   }

  ngOnInit(): void {
  }

  updateCart(album: Album): void{
    this.cart.push(album);
    console.log(`Yep, ${album.name} was added.`);
  }

}
