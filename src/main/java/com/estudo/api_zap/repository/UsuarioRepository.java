package com.estudo.api_zap.repository;

import com.estudo.api_zap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<User, UUID> {

    User findByEmail(String email);

    User findByName(String name);
}
