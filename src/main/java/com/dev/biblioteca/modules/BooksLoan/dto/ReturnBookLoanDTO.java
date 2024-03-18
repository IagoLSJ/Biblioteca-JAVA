package com.dev.biblioteca.modules.BooksLoan.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBookLoanDTO {
    private UUID id;
    private UUID userId;
    private UUID bookId;
    private LocalDateTime devolutionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
