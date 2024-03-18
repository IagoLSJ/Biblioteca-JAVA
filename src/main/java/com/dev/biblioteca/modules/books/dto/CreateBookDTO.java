package com.dev.biblioteca.modules.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBookDTO {
    private String title;
    private String author;
    private int copies;
}
