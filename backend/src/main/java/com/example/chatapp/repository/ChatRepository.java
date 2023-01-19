package com.example.chatapp.repository;

import com.example.chatapp.model.Chat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAllByOrderByCreatedOnDesc();
}
