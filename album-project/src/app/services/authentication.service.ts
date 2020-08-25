import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { User } from '../models/User';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>
      (JSON.parse(sessionStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
   }

   // currentUser is currentUserSubject in Observable form;
   // the desired value is stored in currentUserSubject.
   // Use this value to determine whether user is logged in or not.
  public get currentUserValue(): User {
    return this.currentUserSubject.value;
   }

  login(username, password) {
    return this.http.post<any>(`${config.apiUrl}/users/authenticate`,
      { username, password })
      .pipe(map(user => {
        // store user details and JWT token in *session* storage to keep
        // user logged in between page refreshes within a browser session
        sessionStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        return user;
      }));
  }

  logout(): void {
    // remove user from *session* storage, and set current user to null
    // (remember, currentUser is currentUserSubject in Observable form;
    // the desired value is stored in currentUserSubject (value signifies
    // whether user is logged in or not).
    sessionStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
   }
}
