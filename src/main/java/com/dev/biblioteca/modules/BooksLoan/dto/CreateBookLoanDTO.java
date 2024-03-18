package com.dev.biblioteca.modules.BooksLoan.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookLoanDTO {
    private UUID userId;
    private UUID bookId;
}
