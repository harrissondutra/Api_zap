package com.estudo.api_zap.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "chat", schema = "zap")
@EnableJpaAuditing
@Data
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    private LocalDateTime time = LocalDateTime.now();


}
