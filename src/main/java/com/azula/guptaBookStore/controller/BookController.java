package com.azula.guptaBookStore.controller;

import com.azula.guptaBookStore.dto.BookResponse;
import com.azula.guptaBookStore.dto.CreateBookRequest;
import com.azula.guptaBookStore.dto.UpdateBookRequest;
import com.azula.guptaBookStore.dto.UpdateStockRequest;
import com.azula.guptaBookStore.entity.Book;
import com.azula.guptaBookStore.exception.BookNotFoundException;
import com.azula.guptaBookStore.exception.DuplicateIsbnException;
import com.azula.guptaBookStore.exception.InvalidPriceException;
import com.azula.guptaBookStore.serviceImpl.BookServiceImpl;
import com.azula.guptaBookStore.utility.ResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookStore/books")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody CreateBookRequest request) throws DuplicateIsbnException {
        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getIsbn(),
                request.getStock(),
                request.getPrice()
        );

        Book savedBook = bookService.addBook(book);

        BookResponse response = ResponseMapper.mapper(savedBook);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) throws BookNotFoundException {
        Book book=bookService.getBookById(id);
        return ResponseEntity.ok(ResponseMapper.mapper(book));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody UpdateBookRequest request) throws InvalidPriceException{
        Book updatedBook=bookService.updateBook(
                id,
                request.getTitle(),
                request.getAuthor(),
                request.getPrice()
        );

        BookResponse response = ResponseMapper.mapper(updatedBook);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateStock/{id}")
    public ResponseEntity<BookResponse> updateBookStock(@PathVariable Long id, @Valid @RequestBody UpdateStockRequest request) throws BookNotFoundException {

        Book updatedBook=bookService.updateBookStock(id,request.getStock());

        BookResponse response = ResponseMapper.mapper(updatedBook);

        return ResponseEntity.ok(response);
    }

    @GetMapping("isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Book book=bookService.getBookByIsbn(isbn);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books=bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) throws BookNotFoundException {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
