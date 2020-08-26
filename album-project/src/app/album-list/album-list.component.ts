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

  albumList: Album[]; // Represents list + any search values
  wholeList: Album[]; // Represents entire list of albums without search features
  searchTitle: string; // Represents Title to search by
  searchGenre: number; // Represents Genre to search by
  searchArtist: number; // Represents Artist to search by


  constructor(private albumServ: AlbumServiceService) {
    this.albumList = this.albumServ.getAlbums();
    this.wholeList = this.albumList;
    this.searchTitle = '';
   }

  ngOnInit(): void {
    this.albumList = this.albumServ.getAlbums();
    this.wholeList = this.albumList;
  }

  addToCart(id: number): void {
    const indexOfId = (album: Album) => album.id === id; // Callback function for find index
    const albumIndex = this.albumList.findIndex(indexOfId); // Perform the search
    const chosenAlbum = this.albumList[albumIndex];
    console.log(`Trying to add ${chosenAlbum.name} to cart...`);
    this.toCart.emit(chosenAlbum);
  }

  search(): void {
    this.albumList = this.wholeList.filter(this.hasSearchTitle.bind(this));
    console.log(this.albumList);
    console.log(`Search title: ${this.searchTitle} - Search Genre: ${this.searchGenre} - Search Artist ${this.searchArtist}`);
  }

  // Used for Filter of Album List. If the title of the album matches the given
  // regular expression based on the input title, then it'll be included.
  hasSearchTitle(element: Album, index, array): boolean{
    const searchBy = this.searchTitle;
    const regex = '.*' + searchBy + '.*';
    const regex2 = new RegExp(regex, 'i');
    console.log(regex + ' and ' + element.name);
    if (element.name.search(regex2) !== -1){
      return true;
    }
    return false;
  }
}

