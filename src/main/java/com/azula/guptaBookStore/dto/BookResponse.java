package com.azula.guptaBookStore.dto;

public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int stock;

    public BookResponse() {
    }

    public BookResponse(Long id, String title, String author, String isbn, double price, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
