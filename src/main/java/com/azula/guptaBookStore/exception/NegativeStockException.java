package com.azula.guptaBookStore.exception;

public class NegativeStockException extends Exception{

    public NegativeStockException(String message){
        super(message);
    }
}
