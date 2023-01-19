package com.example.chatapp.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageResponseDto {
    private Long id;
    private String from;
    private String message;
    private LocalDateTime date;
    private Long chatId;
}
