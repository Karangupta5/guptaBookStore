package com.azula.guptaBookStore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public class CreateBookRequest {

    @NotBlank(message = "Title must not be empty")
    private String title;

    @NotBlank(message = "Author must not be empty")
    private String author;

    @NotBlank(message = "ISBN must not be empty")
    private String isbn;

    @NotBlank(message = "Price is compulsory")
    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @Min(value = 0,message = "Stock cannot be negative")
    private int stock;

    public CreateBookRequest(){}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
