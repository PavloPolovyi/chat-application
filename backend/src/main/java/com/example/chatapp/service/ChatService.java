package com.example.chatapp.service;

import com.example.chatapp.model.Chat;
import java.util.List;

public interface ChatService {
    Chat get(Long id);

    Chat add(Chat chat);

    List<Chat> getAll();
}
