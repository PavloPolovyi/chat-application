package com.example.chatapp.repository;

import com.example.chatapp.model.ChatMessage;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    @Query("FROM ChatMessage c WHERE c.chat.id = :chatId ORDER BY c.date")
    List<ChatMessage> findAllByChatId(Long chatId);

    Page<ChatMessage> findAllByChatId(Long chatId, Pageable pageable);
}
