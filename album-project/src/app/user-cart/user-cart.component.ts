import { Component, OnInit, Input } from '@angular/core';
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

}
