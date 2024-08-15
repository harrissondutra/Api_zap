package com.estudo.api_zap.repository;

import com.estudo.api_zap.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
