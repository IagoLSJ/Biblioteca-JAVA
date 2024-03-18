package com.dev.biblioteca.modules.books.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBookDTO {
    private UUID id;
    private String title;
    private String author;
    private int copies;
    private LocalDateTime createedAt;
    private LocalDateTime updatedAt;
}
