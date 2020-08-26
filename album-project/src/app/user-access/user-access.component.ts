import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-user-access',
  templateUrl: './user-access.component.html',
  styleUrls: ['./user-access.component.css']
})
export class UserAccessComponent implements OnInit {
  @Output() userAccess: EventEmitter<boolean> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  signUp(status: boolean): void{
    this.userAccess.emit(status);
  }

  login(status: boolean): void{
    this.userAccess.emit(status);
  }

}
