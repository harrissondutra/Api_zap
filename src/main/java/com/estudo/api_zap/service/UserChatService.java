package com.estudo.api_zap.service;

import com.estudo.api_zap.model.Chat;
import com.estudo.api_zap.model.User;
import com.estudo.api_zap.model.UserChat;
import com.estudo.api_zap.repository.ChatRepository;
import com.estudo.api_zap.repository.UserChatRepository;
import com.estudo.api_zap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserChatService {

    @Autowired
    private UserChatRepository repository;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    public ResponseEntity<UserChat> save(UUID userId, Long chatId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Chat não encontrado"));

        UserChat userChat = new UserChat();
        userChat.setUser(user.getId().toString());
        userChat.setChat(chat.getId());

        if(repository.findById(userChat.getId()).isPresent()){
            throw new RuntimeException("Chat já existe");
        }

        return ResponseEntity.ok(repository.save(userChat));
    }

    public UserChat getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Chat não encontrado"));
    }

    public ResponseEntity<List<UserChat>> getChatsByUserId(UUID userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

       try {
              return ResponseEntity.ok(repository.findAllByUser(user.getId().toString()));
         } catch (Exception e) {
              return ResponseEntity.notFound().build();
       }
    }
}
