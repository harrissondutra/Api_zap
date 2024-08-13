package com.estudo.api_zap.model;

import com.estudo.api_zap.DTO.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@Table(name = "user", schema = "zap")
@EnableJpaAuditing
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;


    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId().toString())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
