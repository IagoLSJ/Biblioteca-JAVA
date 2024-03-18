package com.dev.biblioteca.modules.BooksLoan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.biblioteca.modules.BooksLoan.dto.CreateBookLoanDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/bookLoan")
public class BookLoanController {
    @Autowired
    private BookLoanService bookLoanService;

    @PostMapping("/")
    public BookLoanEntity postMethodName(@RequestBody CreateBookLoanDTO create) {
    
        return this.bookLoanService.create(create);
    }
    
}
