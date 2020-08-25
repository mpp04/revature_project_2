import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Album } from '../models/Album';

@Component({
  selector: 'app-user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.css']
})
export class UserCartComponent implements OnInit {
  @Input() cart: Album[];

  constructor() { }

  ngOnInit(): void {
  }

  deleteFromCart(id: number): void {
    const indexOfId = (album: Album) => album.id === id; // Callback function for find index
    const albumIndex = this.cart.findIndex(indexOfId); // Perform the search
    const chosenAlbum = this.cart.splice(albumIndex - 1, 1);
    console.log(chosenAlbum);
    console.log(`${chosenAlbum[0].name} removed to cart`);
  }

}
