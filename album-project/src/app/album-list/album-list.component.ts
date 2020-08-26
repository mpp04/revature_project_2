import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AlbumServiceService } from '../services/album-service.service';
import { Album } from '../models/Album';

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.css']
})
export class AlbumListComponent implements OnInit {

  @Output() toCart: EventEmitter<Album> = new EventEmitter();

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

  addToCart(id: number): void {
    const indexOfId = (album: Album) => album.id === id; // Callback function for find index
    const albumIndex = this.albumList.findIndex(indexOfId); // Perform the search
    const chosenAlbum = this.albumList[albumIndex];
    console.log(`${chosenAlbum.name} added to cart`);

    console.log(`Trying to add ${chosenAlbum.name} to cart...`);

    this.toCart.emit(chosenAlbum);
  }

  search(): void {
    console.log(`Search title: ${this.searchTitle} - Search Genre: ${this.searchGenre} - Search Artist ${this.searchArtist}`);
  }
}
<<<<<<< HEAD
=======

>>>>>>> 15fdd7b55e1891da5f8bc9f9d9db1d2c10e0acef
