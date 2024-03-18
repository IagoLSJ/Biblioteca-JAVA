package com.dev.biblioteca.modules.books;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<BooksEntity, UUID> {
    BooksEntity findByTitle(String title);
}
