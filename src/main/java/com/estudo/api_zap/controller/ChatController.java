package com.estudo.api_zap.controller;

import com.estudo.api_zap.model.Chat;
import com.estudo.api_zap.model.Message;
import com.estudo.api_zap.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Gerenciar Chat", description = "Operações relacionadas a chat")
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @Operation(summary = "Criar um novo chat", description = "Enviando um chat, um novo chat será criado")
    @PostMapping("/createChat")
    public Chat createChat(Chat chat) {
        return service.save(chat);
    }

    @Operation(summary = "Listar todos os chats", description = "Listar todos os chats cadastrados")
    @GetMapping("/getAll")
    public List<Chat> getAllChats() {
        return service.findAll();
    }

    @Operation(summary = "Buscar chat por ID", description = "Buscar chat por ID")
    @GetMapping("/getById")
    public Chat getById(Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Buscar mensagens de chat por ID do Chat", description = "Buscar mensagens de chat por ID do Chat")
    @GetMapping("/getMessagesByChatId")
    public List<Message> getMessagesByChatId(Long chatId) {
        return service.getMessagesByChatId(chatId);
    }


}
