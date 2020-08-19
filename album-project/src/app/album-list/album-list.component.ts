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

  constructor(private albumServ: AlbumServiceService) { }

  ngOnInit(): void {
    this.albumList = this.albumServ.getAlbums();
  }

}
