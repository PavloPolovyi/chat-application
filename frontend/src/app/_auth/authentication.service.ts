import { Injectable } from '@angular/core';
import {AuthenticationClient} from './authentication.client';
import {Router} from '@angular/router';
import {User} from '../_model/user';
import {environment} from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private authenticationClient: AuthenticationClient,
              private router: Router) { }

  public login(user: User): void {
    this.authenticationClient.login(user).subscribe((token) => {
      localStorage.setItem(environment.tokenKey, token.value);
      localStorage.setItem(environment.userKey, user.nickName);
      this.router.navigate(['/']);
    });
  }

  public register(user: User): void {
    this.authenticationClient
      .register(user)
      .subscribe(response => this.router.navigate(['/login']));
  }

  public logout() {
    localStorage.removeItem(environment.userKey);
    this.router.navigate(['/login']);
  }

  public isLoggedIn(): boolean {
    let token = localStorage.getItem(environment.tokenKey);
    return token != null && token.length > 0;
  }

  public getToken(): string | null {
    return this.isLoggedIn() ? localStorage.getItem(environment.tokenKey) : null;
  }
}
