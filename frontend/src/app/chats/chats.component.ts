import {
  ChangeDetectorRef,
  Component, EventEmitter,
  OnInit, Output
} from '@angular/core';
import {ChatService} from "../_service/chat.service";
import {Chat} from "../_model/chat";
import {Subscription} from "rxjs";
import {RxStompService} from "../_service/rx-stomp.service";
import {Message} from "@stomp/stompjs";
import {ChatMessage} from "../_model/message";

@Component({
  selector: 'app-chats',
  templateUrl: './chats.component.html',
  styleUrls: ['./chats.component.css']
})
export class ChatsComponent implements OnInit {
  chats?:Chat[];
  subscriptionStomp?: Subscription;
  @Output() eventEmitter = new EventEmitter<Chat>();
  selectedChat?:Chat;
  unreadMessagesChatId:number[] = [];

  constructor(private chatService: ChatService,
              private rxStompService: RxStompService, private ref: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    this.getChats();
    this.subscriptionStomp = this.rxStompService.watch('/topic/chats')
      .subscribe((message: Message) => {
        this.addUnreadMessage(message);
      });
  }

  private addUnreadMessage(message: Message) {
    const chatMessage: ChatMessage = JSON.parse(message.body);
    const chat = this.chats?.find(chat => chat.id === chatMessage.chatId);
    if (chat != undefined) {
      chat.lastMessageSend = chatMessage.message;
      chat.lastMessageSendTime = chatMessage.date;
      if (this.selectedChat != chat) {
        this.unreadMessagesChatId.push(chat.id);
      }
    }
  }

  getChats(): void {
    this.chatService.getAllChats().subscribe(chats => this.chats = chats);
    setTimeout(() => {
      if (this.chats != undefined && this.chats?.length > 0) {
        this.addChatToEmitter(this.chats[0]);
      }
    }, 150);
  }

  addChat(name: string): void {
    name = name.trim();
    if (!name) return;
    this.chatService.addChat(name)
      .subscribe(chat => {
        this.chats?.unshift(chat);
        this.ref.detectChanges();
      });
    setTimeout(() => {
      if (this.chats != undefined && this.chats?.length > 0) {
        this.addChatToEmitter(this.chats[0]);
      }
    }, 150);
  }

  addChatToEmitter(chat: Chat) {
    this.eventEmitter.emit(chat);
    this.selectedChat = chat;
    const index = this.unreadMessagesChatId.indexOf(chat.id);
    if (index != -1) {
      this.unreadMessagesChatId.splice(index, 1);
    }
  }
}
