import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {User} from "../_model/user";
import {catchError, Observable} from "rxjs";
import {environment} from "../../environment/environment";
import {AbstractService} from "../_service/abstract.service";
import {Token} from "../_model/token";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationClient extends AbstractService {

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }

  public login(user: User): Observable<Token> {
    return this.client
      .post<Token>(environment.apiUrl + '/' + 'login', user, this.httpOptions)
      .pipe(catchError(this.handleError<Token>(`login failed for ${user.nickName}`)))
  }

  public register(user: User): Observable<HttpResponse<any>> {
    return this.client
      .post<HttpResponse<any>>(environment.apiUrl + '/' + 'register',
        user, {observe: 'response'})
      .pipe(catchError(this.handleError<HttpResponse<any>>(`register failed for ${user.nickName}`)));
  }
}
