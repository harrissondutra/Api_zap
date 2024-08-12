package com.estudo.api_zap.service;

import com.estudo.api_zap.model.User;
import com.estudo.api_zap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public User findByName(String name) {
        return repository.findByName(name);
    }
}
