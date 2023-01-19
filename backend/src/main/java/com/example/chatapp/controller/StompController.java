package com.example.chatapp.controller;

import com.example.chatapp.dto.ChatMessageRequestDto;
import com.example.chatapp.dto.ChatMessageResponseDto;
import com.example.chatapp.mapper.request.ChatMessageRequestMapper;
import com.example.chatapp.mapper.response.ChatMessageResponseMapper;
import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.service.ChatMessageService;
import com.example.chatapp.service.ChatService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class StompController {
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    private final ChatMessageRequestMapper chatMessageRequestMapper;
    private final ChatMessageResponseMapper chatMessageResponseMapper;

    @MessageMapping("/chats/{chatId}")
    @SendTo("/topic/chats")
    public ChatMessageResponseDto chat(@DestinationVariable Long chatId,
                                       ChatMessageRequestDto dto) {
        ChatMessage chatMessage = chatMessageRequestMapper.toModel(dto);
        chatMessage.setChat(chatService.get(chatId));
        chatMessage.setDate(LocalDateTime.now());
        return chatMessageResponseMapper.toDto(chatMessageService.add(chatMessage));
    }
}
