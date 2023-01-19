package com.example.chatapp.mapper.request;

import com.example.chatapp.dto.ChatMessageRequestDto;
import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.model.User;
import com.example.chatapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatMessageRequestMapper {
    private final UserRepository userRepository;

    public ChatMessage toModel(ChatMessageRequestDto dto) {
        ChatMessage chatMessage = new ChatMessage();
        User user = userRepository.findUserByNickName(dto.getFrom()).orElseThrow();
        chatMessage.setSendFrom(user);
        chatMessage.setMessage(dto.getMessage());
        return chatMessage;
    }
}
