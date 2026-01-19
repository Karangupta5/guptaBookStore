package com.azula.guptaBookStore.service;

import com.azula.guptaBookStore.entity.Book;
import com.azula.guptaBookStore.exception.BookNotFoundException;
import com.azula.guptaBookStore.exception.DuplicateIsbnException;
import com.azula.guptaBookStore.exception.InvalidPriceException;

import java.util.List;

public interface BookService {

    Book addBook(Book book) throws DuplicateIsbnException;

    Book updateBook(long id,Book updatedBook) throws InvalidPriceException;

    Book updateBookStock(long id,int newStock) throws BookNotFoundException;

    Book getBookById(long id) throws BookNotFoundException;

    Book getBookByIsbn(String isbn);

    List<Book> getAllBooks();

    void deleteBook(long id) throws BookNotFoundException;
}
