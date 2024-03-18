package com.dev.biblioteca.modules.BooksLoan;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.biblioteca.modules.BooksLoan.dto.CreateBookLoanDTO;
import com.dev.biblioteca.modules.books.BooksService;
import com.dev.biblioteca.modules.books.dto.ReturnBookDTO;
import com.dev.biblioteca.modules.configs.erros.ResourceNotFoundException;

@Service
public class BookLoanService {
    @Autowired
    private BookLoanRepository bookLoanRepository;

    @Autowired
    private BooksService booksService;



    public BookLoanEntity create(CreateBookLoanDTO create){
        ReturnBookDTO findBook = this.booksService.findById(create.getBookId());

        if(findBook.getCopies()==0){
          throw new ResourceNotFoundException("Livro não disponivel");
        }

        LocalDateTime devolutionDate = LocalDateTime.now();



        BookLoanEntity bookLoan = new BookLoanEntity();
        bookLoan.setBookId(create.getBookId());
        bookLoan.setUserId(create.getUserId());
        bookLoan.setDevolutionDate(devolutionDate.plusDays(5));

        return this.bookLoanRepository.save(bookLoan);

    }
}
