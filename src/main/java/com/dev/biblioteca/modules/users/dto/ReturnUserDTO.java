package com.dev.biblioteca.modules.users.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dev.biblioteca.modules.users.types.UsersTypes;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnUserDTO {
    private UUID id;
    
    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private UsersTypes usersType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp 
    private LocalDateTime updatedAt;
}
