import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, Observable} from "rxjs";
import {ChatMessage} from '../_model/message';
import {environment} from '../../environment/environment';
import {AbstractService} from './abstract.service';

@Injectable({
  providedIn: 'root'
})
export class MessageService extends AbstractService {
  private url: string = environment.apiUrl + '/' + 'chats';

  constructor(httpClient: HttpClient) {
    super(httpClient);
  }

  public getAllMessages(chatId: number | undefined): Observable<ChatMessage[]> {
    return this.client.get<ChatMessage[]>(this.url + '/' + chatId)
      .pipe(catchError(this.handleError<ChatMessage[]>("getting all messages", [])));
  }
}
