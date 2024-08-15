package com.estudo.api_zap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "message", schema = "zap")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
}