package com.azula.guptaBookStore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UpdateBookRequest {

    @NotBlank(message = "Title must not be empty")
    private String title;

    @NotBlank(message = "Author must not be empty")
    private String author;

    @Min(value = 1,message = "Price must be greater than 0")
    private double price;

    public UpdateBookRequest() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
