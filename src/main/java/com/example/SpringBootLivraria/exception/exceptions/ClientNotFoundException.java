package com.example.SpringBootLivraria.exception.exceptions;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(String message){
        super(message);
    }
}
