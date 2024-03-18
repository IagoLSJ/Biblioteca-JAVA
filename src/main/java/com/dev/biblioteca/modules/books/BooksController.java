package com.dev.biblioteca.modules.books;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.biblioteca.modules.books.dto.CreateBookDTO;
import com.dev.biblioteca.modules.books.dto.ReturnBookDTO;
import com.dev.biblioteca.modules.books.dto.UpdateBookDTO;

import jakarta.websocket.server.PathParam;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/")
    public List<ReturnBookDTO> findAll() {
        return this.booksService.findAll();
    }

    @GetMapping("/find-title/")
    public ReturnBookDTO findByTitle(@PathParam(value = "title") String title) {
        return this.booksService.findBookByTitle(title);
    }

    @GetMapping("/{id}")
    public ReturnBookDTO findById(@RequestParam UUID id) {
        return this.booksService.findById(id);

    }

    @PostMapping("/")
    public ReturnBookDTO create(@RequestBody CreateBookDTO create) {
        ReturnBookDTO result = this.booksService.create(create);
        return result;
    }
    
    @PutMapping("/update/{id}")
    public ReturnBookDTO updateBook(@PathVariable("id") UUID id, @RequestBody UpdateBookDTO updateBookDTO) {
        return this.booksService.update(id, updateBookDTO);

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id){
        this.booksService.delete(id);
        return "Book deleted";
    }

}
