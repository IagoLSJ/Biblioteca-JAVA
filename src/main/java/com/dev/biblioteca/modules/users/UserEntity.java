package com.dev.biblioteca.modules.users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dev.biblioteca.modules.users.types.UsersTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
public class UserEntity { 
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String hashPassword;

    @Enumerated(EnumType.STRING)
    private UsersTypes usersType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp 
    private LocalDateTime updatedAt;
    
}  
