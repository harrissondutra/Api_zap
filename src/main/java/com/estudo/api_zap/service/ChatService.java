package com.estudo.api_zap.service;

import com.estudo.api_zap.model.Chat;
import com.estudo.api_zap.model.Message;
import com.estudo.api_zap.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository repository;

    public Chat save(Chat chat) {
        return repository.save(chat);
    }

    public List<Chat> findAll() {
        return repository.findAll();
    }

    public Chat getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Chat não encontrado"));
    }

    public List<Message> getMessagesByChatId(Long chatId) {
        Chat chat = repository.findById(chatId).orElseThrow(() -> new RuntimeException("Chat não encontrado"));
        return chat.getMessages();
    }
}

