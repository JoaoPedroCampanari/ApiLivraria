package com.example.SpringBootLivraria.exception.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message){
        super(message);
    }

}
