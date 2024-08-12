package com.estudo.api_zap.DTO;

import com.estudo.api_zap.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class UserDto {
    private String id;
    private String name;
    private String email;

    public User toEntity(UserDto dto){
        return User.builder()
                .id(UUID.fromString(dto.getId()))
                .name(dto.getName())
                .email(dto.getEmail())
                .build();

    }
}

