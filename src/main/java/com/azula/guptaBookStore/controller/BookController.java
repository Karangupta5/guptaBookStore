package com.azula.guptaBookStore.controller;

import com.azula.guptaBookStore.entity.Book;
import com.azula.guptaBookStore.exception.BookNotFoundException;
import com.azula.guptaBookStore.exception.DuplicateIsbnException;
import com.azula.guptaBookStore.exception.InvalidPriceException;
import com.azula.guptaBookStore.serviceImpl.BookServiceImpl;
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
    public ResponseEntity<Book> addBook(@RequestBody Book book) throws DuplicateIsbnException {
       Book savedBook=bookService.addBook(book);
       return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/get{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) throws BookNotFoundException {
        Book book=bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book book) throws InvalidPriceException {
        Book updatedBook=bookService.updateBook(id,book);
        return ResponseEntity.ok(updatedBook);
    }

    @PutMapping("/updateStock{id}")
    public ResponseEntity<Book> updateBookStock(@PathVariable Long id,@RequestBody int stock) throws BookNotFoundException {
        Book updatedBook=bookService.updateBookStock(id,stock);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("get/{isbn}")
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
