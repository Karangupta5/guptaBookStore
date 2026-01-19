package com.azula.guptaBookStore.dto;

import jakarta.validation.constraints.Min;

public class UpdateStockRequest {

    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    public UpdateStockRequest() {}

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
