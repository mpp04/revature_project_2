import { Injectable } from '@angular/core';
import { Album } from '../models/Album';

@Injectable({
  providedIn: 'root'
})
export class AlbumServiceService {

  constructor() { }

  getAlbums(): Album[] {
    return null;
   }
}
