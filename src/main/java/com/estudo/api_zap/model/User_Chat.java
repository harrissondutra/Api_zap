package com.estudo.api_zap.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Table(name = "user_chat", schema = "zap")
@EnableJpaAuditing
@Data
@Entity
public class User_Chat {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat_id;


}
