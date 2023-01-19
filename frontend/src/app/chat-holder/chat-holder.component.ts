import {Component, Input} from '@angular/core';
import {Chat} from "../_model/chat";

@Component({
  selector: 'app-chat-holder',
  templateUrl: './chat-holder.component.html',
  styleUrls: ['./chat-holder.component.css']
})
export class ChatHolderComponent {
  @Input() emittedChat?: Chat;
}
