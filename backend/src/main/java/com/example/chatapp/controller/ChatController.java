package com.example.chatapp.controller;

import com.example.chatapp.dto.ChatMessageResponseDto;
import com.example.chatapp.dto.ChatRequestDto;
import com.example.chatapp.dto.ChatResponseDto;
import com.example.chatapp.mapper.request.ChatRequestMapper;
import com.example.chatapp.mapper.response.ChatMessageResponseMapper;
import com.example.chatapp.mapper.response.ChatResponseMapper;
import com.example.chatapp.model.Chat;
import com.example.chatapp.service.ChatMessageService;
import com.example.chatapp.service.ChatService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chats")
public class ChatController {
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    private final ChatMessageResponseMapper chatMessageResponseMapper;
    private final ChatRequestMapper chatRequestMapper;
    private final ChatResponseMapper chatResponseMapper;

    @PostMapping
    public ChatResponseDto createChat(@RequestBody ChatRequestDto chatRequestDto) {
        Chat chat = chatRequestMapper.toModel(chatRequestDto);
        chat.setCreatedOn(LocalDateTime.now());
        return chatResponseMapper.toDto(chatService.add(chat));
    }

    @GetMapping
    public List<ChatResponseDto> getAllChats() {
        return chatService.getAll().stream()
                .map(chatResponseMapper::toDto)
                .toList();
    }

    @GetMapping("/{chatId}")
    public List<ChatMessageResponseDto> getAllMessages(
            @PathVariable Long chatId) {
        return chatMessageService.getAllByChatId(chatId).stream()
                .map(chatMessageResponseMapper::toDto)
                .toList();
    }
}
