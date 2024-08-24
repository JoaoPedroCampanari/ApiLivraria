package com.example.SpringBootLivraria.exception.exceptions;

public class CpfAlreadyExistsException extends RuntimeException{

    public CpfAlreadyExistsException(String message){
        super(message);
    }
}
