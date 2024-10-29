package com.walter.example.excepciones;

public class StockInsuficiente extends RuntimeException {

    public StockInsuficiente(String message) {

        super(message);

    }
}
