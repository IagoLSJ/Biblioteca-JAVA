package com.dev.biblioteca.modules.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    private String name;
    private String email;
    private String password;
}
