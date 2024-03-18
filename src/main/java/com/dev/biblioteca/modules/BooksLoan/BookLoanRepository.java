package com.dev.biblioteca.modules.BooksLoan;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoanEntity, UUID> {
    
}
