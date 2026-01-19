package com.azula.guptaBookStore.utility;

import com.azula.guptaBookStore.dto.BookResponse;
import com.azula.guptaBookStore.entity.Book;

public class ResponseMapper {

    public static BookResponse mapper(Book updatedBook){
        BookResponse response = new BookResponse(
                updatedBook.getId(),
                updatedBook.getTitle(),
                updatedBook.getAuthor(),
                updatedBook.getIsbn(),
                updatedBook.getPrice(),
                updatedBook.getStock()
        );
        return response;
    }
}
