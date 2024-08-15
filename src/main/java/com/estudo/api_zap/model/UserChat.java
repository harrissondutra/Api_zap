package com.estudo.api_zap.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.net.ssl.SSLSession;
import java.util.UUID;

@Table(name = "user_chat", schema = "zap")
@EnableJpaAuditing
@Data
@Entity
public class UserChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String user;

    @Column(name = "chat_id")
    private Long chat;

}
