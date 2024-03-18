package com.dev.biblioteca.modules.BooksLoan;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="BooksLoan")
public class BookLoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;
    private UUID bookId;
    private LocalDateTime devolutionDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp 
    private LocalDateTime updatedAt;

}
