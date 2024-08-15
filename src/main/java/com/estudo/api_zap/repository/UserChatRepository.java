package com.estudo.api_zap.repository;

import com.estudo.api_zap.model.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChatRepository extends JpaRepository<UserChat, Long> {

    List<UserChat> findAllByUser(String user);
}
