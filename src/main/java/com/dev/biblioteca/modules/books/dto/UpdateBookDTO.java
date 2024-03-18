package com.dev.biblioteca.modules.books.dto;

import lombok.Data;

@Data
public class UpdateBookDTO {
    private String title;
    private String author;
    private int copies;
}
