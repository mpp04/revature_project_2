import { Injectable } from '@angular/core';
import { Album } from '../models/Album';

@Injectable({
  providedIn: 'root'
})
export class AlbumServiceService {

  constructor() { }

  getAlbums(): Album[] {
    const albums: Album[] = [
      {
        id: 0,
        name: 'Good Old Organ Ice',
        art: 'https://files.freemusicarchive.org/storage-freemusicarchive-org/images/albums/Lobo_Loco_-_Good_Old_Organ_Ice_-_2019030233452214.jpg?width=290&height=290',
        artist: 'Lobo Loco',
        genre: 'Old-time',
        price: 0
      },
      {
        id: 1,
        name: 'It Rains - Abstract Jazz',
        art: 'https://files.freemusicarchive.org/storage-freemusicarchive-org/images/albums/Mid-Air_Machine_-_Night_Ward__Abstract_Jazz_-_2018072380709577.jpg?width=290&height=290',
        artist: 'Mid-Air Machine',
        genre: 'Jazz',
        price: 0
      },
      {
        id: 2,
        name: 'Arps',
        art: 'https://files.freemusicarchive.org/storage-freemusicarchive-org/images/albums/Chad_Crouch_-_Arps_-_20190913144052757.jpg?width=290&height=290',
        artist: 'Chad Crouch',
        genre: 'Electronic',
        price: 0
      }
    ];
    return albums;
  }
}
