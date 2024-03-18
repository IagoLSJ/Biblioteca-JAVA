package com.dev.biblioteca.modules.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.biblioteca.modules.books.dto.CreateBookDTO;
import com.dev.biblioteca.modules.books.dto.ReturnBookDTO;
import com.dev.biblioteca.modules.books.dto.UpdateBookDTO;
import com.dev.biblioteca.modules.configs.erros.ResourceNotFoundException;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;


    public List<ReturnBookDTO> findAll(){
        List<BooksEntity> result = this.booksRepository.findAll();
        List<ReturnBookDTO> resultBooks = new ArrayList<>();

        for(BooksEntity book : result){
            ReturnBookDTO resultBook = new ReturnBookDTO();

            resultBook.setId(book.getId());
            resultBook.setTitle(book.getTitle());
            resultBook.setAuthor(book.getAuthor());
            resultBook.setCopies(book.getCopies());
            resultBook.setCreateedAt(book.getCreateedAt());
            resultBook.setUpdatedAt(book.getUpdatedAt());

            resultBooks.add(resultBook);
        }

        return resultBooks;

    }

    public ReturnBookDTO  findById(UUID id) {
        Optional<BooksEntity> result = this.booksRepository.findById(id);
        
        if(!result.isPresent()){
            throw new ResourceNotFoundException("Livro não encontrado");
        }
        
        ReturnBookDTO resultBook = new ReturnBookDTO();

        resultBook.setId(result.get().getId());
        resultBook.setTitle(result.get().getTitle());
        resultBook.setAuthor(result.get().getAuthor());
        resultBook.setCopies(result.get().getCopies());
        resultBook.setCreateedAt(result.get().getCreateedAt());
        resultBook.setUpdatedAt(result.get().getUpdatedAt());

        return resultBook;
    }

    public ReturnBookDTO findBookByTitle(String title){
        BooksEntity result = this.booksRepository.findByTitle(title);
        if(result == null){
            return null;
        }
        ReturnBookDTO resultBook = new ReturnBookDTO();
        resultBook.setId(result.getId());
        resultBook.setTitle(result.getTitle());
        resultBook.setAuthor(result.getAuthor());
        resultBook.setCopies(result.getCopies());
        resultBook.setCreateedAt(result.getCreateedAt());
        resultBook.setUpdatedAt(result.getUpdatedAt());

        return resultBook;
    }


    public ReturnBookDTO create(CreateBookDTO createBookd){
        var titleIsAvailable = this.findBookByTitle(createBookd.getTitle());

        if(titleIsAvailable != null){
             throw new ResourceNotFoundException("Esse titulo já esta cadastrado");
        }

        if(createBookd.getCopies() <= 0){
            throw new ResourceNotFoundException("Não e permitido cadastrar livros com o campo copies negativo ou 0");
        }
        BooksEntity createBook = new BooksEntity();

        createBook.setAuthor(createBookd.getAuthor());
        createBook.setCopies(createBookd.getCopies());
        createBook.setTitle(createBookd.getTitle());

        BooksEntity createdBook = booksRepository.save(createBook);

        ReturnBookDTO createdBookDTO = new ReturnBookDTO();

        createdBookDTO.setId(createdBook.getId());
        createdBookDTO.setTitle(createdBook.getTitle());
        createdBookDTO.setAuthor(createdBook.getAuthor());
        createdBookDTO.setCopies(createdBook.getCopies());
        createdBookDTO.setCreateedAt(createdBook.getCreateedAt());
        createdBookDTO.setUpdatedAt(createdBook.getUpdatedAt());

        return createdBookDTO;
        
    }

 

    public ReturnBookDTO update(UUID bookId, UpdateBookDTO updateBook){
        BooksEntity bookById = this.booksRepository.findById(bookId).get();

        if(bookById == null){
            return null;
        }

        if(updateBook.getAuthor() != null){
            bookById.setAuthor(updateBook.getAuthor());
        }

        if(updateBook.getTitle() != null){
            bookById.setTitle(updateBook.getTitle());
        }

        if(updateBook.getCopies() > 0){
            bookById.setCopies(updateBook.getCopies());
        }
        
        BooksEntity bookUpdated = this.booksRepository.save(bookById);

        ReturnBookDTO bookUpdatedDTO = new ReturnBookDTO();

        bookUpdatedDTO.setId(bookUpdated.getId());
        bookUpdatedDTO.setTitle(bookUpdated.getTitle());
        bookUpdatedDTO.setAuthor(bookUpdated.getAuthor());
        bookUpdatedDTO.setCopies(bookUpdated.getCopies());
        bookUpdatedDTO.setCreateedAt(bookUpdated.getCreateedAt());
        bookUpdatedDTO.setUpdatedAt(bookUpdated.getUpdatedAt());

        return bookUpdatedDTO;
    }


   


    public void delete(UUID id){
        this.booksRepository.deleteById(id);
    }
}
