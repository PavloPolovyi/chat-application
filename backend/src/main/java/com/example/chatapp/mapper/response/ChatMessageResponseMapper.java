package com.example.chatapp.mapper.response;

import com.example.chatapp.dto.ChatMessageResponseDto;
import com.example.chatapp.model.ChatMessage;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageResponseMapper {
    public ChatMessageResponseDto toDto(ChatMessage chatMessage) {
        ChatMessageResponseDto chatMessageResponseDto = new ChatMessageResponseDto();
        chatMessageResponseDto.setId(chatMessage.getId());
        chatMessageResponseDto.setMessage(chatMessage.getMessage());
        chatMessageResponseDto.setFrom(chatMessage.getSendFrom().getNickName());
        chatMessageResponseDto.setDate(chatMessage.getDate());
        chatMessageResponseDto.setChatId(chatMessage.getChat().getId());
        return chatMessageResponseDto;
    }
}
