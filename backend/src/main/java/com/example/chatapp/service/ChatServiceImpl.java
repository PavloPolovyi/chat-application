package com.example.chatapp.service;

import com.example.chatapp.model.Chat;
import com.example.chatapp.repository.ChatRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Override
    public Chat get(Long id) {
        return chatRepository.findById(id).orElseThrow();
    }

    @Override
    public Chat add(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.findAllByOrderByCreatedOnDesc();
    }
}
