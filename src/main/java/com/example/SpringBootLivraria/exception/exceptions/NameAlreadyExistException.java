package com.example.SpringBootLivraria.exception.exceptions;

public class NameAlreadyExistException extends RuntimeException{

    public NameAlreadyExistException(String message){
        super(message);
    }
}
