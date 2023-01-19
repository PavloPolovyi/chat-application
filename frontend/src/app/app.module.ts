import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { ChatsComponent } from './chats/chats.component';
import { MessagesComponent } from './messages/messages.component';
import { AppRoutingModule } from './app-routing.module';
import {RxStompService} from "./_service/rx-stomp.service";
import {rxStompServiceFactory} from "./_service/rx-stomp-service-factory";
import {TimeagoModule} from "ngx-timeago";
import {MatIconModule} from "@angular/material/icon";
import {TokenInterceptor} from "./_auth/token.interceptor";
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from "@angular/material/input";
import { ChatHolderComponent } from './chat-holder/chat-holder.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    ChatsComponent,
    MessagesComponent,
    LoginPageComponent,
    RegisterPageComponent,
    ChatHolderComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    TimeagoModule.forRoot(),
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatCardModule,
    MatInputModule,
  ],
  providers: [{
    provide: RxStompService,
    useFactory: rxStompServiceFactory,
  }, { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },],
  bootstrap: [AppComponent]
})
export class AppModule { }
