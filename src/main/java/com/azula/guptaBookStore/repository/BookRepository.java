package com.azula.guptaBookStore.repository;

import com.azula.guptaBookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);
}
