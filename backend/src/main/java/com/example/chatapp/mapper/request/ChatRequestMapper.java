package com.example.chatapp.mapper.request;

import com.example.chatapp.dto.ChatRequestDto;
import com.example.chatapp.model.Chat;
import com.example.chatapp.model.User;
import com.example.chatapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatRequestMapper {
    private final UserRepository userRepository;

    public Chat toModel(ChatRequestDto chatRequestDto) {
        Chat chat = new Chat();
        User user = userRepository.findUserByNickName(chatRequestDto.getNickName()).orElseThrow();
        chat.setName(chatRequestDto.getName());
        chat.setUser(user);
        return chat;
    }
}
