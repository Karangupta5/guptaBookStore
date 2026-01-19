package com.azula.guptaBookStore.serviceImpl;

import com.azula.guptaBookStore.entity.Book;
import com.azula.guptaBookStore.exception.BookNotFoundException;
import com.azula.guptaBookStore.exception.DuplicateIsbnException;
import com.azula.guptaBookStore.exception.InvalidPriceException;
import com.azula.guptaBookStore.repository.BookRepository;
import com.azula.guptaBookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) throws DuplicateIsbnException {

        if(bookRepository.existsByIsbn(book.getIsbn())){
            throw new DuplicateIsbnException("Book with this ISBN already exist");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(long id,String title,String author,Double price) throws InvalidPriceException {
        Book book=bookRepository.getById(id);

        book.setTitle(title);
        book.setAuthor(author);
        if(price<=0) throw new InvalidPriceException("Price must be greater than 0");
        book.setPrice(price);

        return bookRepository.save(book);
    }

    @Override
    public Book updateBookStock(long id, int newStock) throws BookNotFoundException {
        if(newStock<0) throw  new RuntimeException("Stock amount must be positive");
        Book book=bookRepository.getById(id);
        if(book==null) throw new BookNotFoundException("Invalid id or Book Not Found");
        book.setStock(book.getStock()+newStock);
        return book;
    }

    @Override
    public Book getBookById(long id) throws BookNotFoundException {
        Book book=bookRepository.getById(id);
        if(book==null) throw new BookNotFoundException("Invalid id or Book Not Found");
        return book;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(long id) throws BookNotFoundException {
        Book book=bookRepository.getById(id);
        if(book==null) throw new BookNotFoundException("Invalid id or Book Not Found");
        bookRepository.delete(book);
    }
}
