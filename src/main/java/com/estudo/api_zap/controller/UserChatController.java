package com.estudo.api_zap.controller;

import com.estudo.api_zap.model.User;
import com.estudo.api_zap.model.UserChat;
import com.estudo.api_zap.service.UserChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Gerenciar Chat de Usuário", description = "Operações relacionadas a chat de usuário")
@RestController
@RequestMapping("/userChat")
public class UserChatController {

    @Autowired
    private UserChatService service;

    @Operation(summary = "Criar um novo chat de usuário", description = "Enviando um userId e um chatId, um novo chat de usuário será criado")
    @PostMapping("/createChat/{userId}/{chatId}")
    public ResponseEntity<UserChat> createUserChat(@PathVariable UUID userId, Long chatId) {
        return service.save(userId, chatId);
    }

    @Operation(summary = "Buscar chat de usuário por ID", description = "Buscar chat de usuário por ID")
    @GetMapping("/getById")
    public UserChat getById(@RequestParam(name = "id") Long id){
        return service.getById(id);
    }

    @Operation(summary = "Buscar chats de usuário por ID de usuário", description = "Buscar chats de usuário por ID de usuário")
    @GetMapping("/getChatsByUserId")
    public ResponseEntity<List<UserChat>> getChatsByUserId(@RequestParam(name = "userId") UUID userId){
        return service.getChatsByUserId(userId);
    }
}
