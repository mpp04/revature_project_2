import { Component, OnInit } from '@angular/core';
import { AlbumServiceService } from '../services/album-service.service';
import { Album } from '../models/Album';

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.css']
})
export class AlbumListComponent implements OnInit {

  albumList: Album[];
  searchTitle: string;
  searchGenre: number;
  searchArtist: number;


  constructor(private albumServ: AlbumServiceService) {
    this.albumList = this.albumServ.getAlbums();
    this.searchTitle = '';
   }

  ngOnInit(): void {
    this.albumList = this.albumServ.getAlbums();

  }

  addToCart(title: string): void {
    console.log(`${title} added to cart`);
  }

  search(): void {
    console.log(`Search title: ${this.searchTitle} - Search Genre: ${this.searchGenre} - Search Artist ${this.searchArtist}`);
  }
}
