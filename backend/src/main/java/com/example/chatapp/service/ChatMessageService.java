package com.example.chatapp.service;

import com.example.chatapp.model.ChatMessage;
import java.util.List;

public interface ChatMessageService {
    ChatMessage add(ChatMessage chatMessage);

    List<ChatMessage> getAllByChatId(Long chatId);
}
