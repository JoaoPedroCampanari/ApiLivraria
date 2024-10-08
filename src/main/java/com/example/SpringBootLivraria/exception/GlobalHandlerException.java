package com.example.SpringBootLivraria.exception;

import com.example.SpringBootLivraria.exception.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> clientNotFoundException (ClientNotFoundException clientNotFoundException){
        return new ResponseEntity<>(clientNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CpfAlreadyExistsException.class)
    public ResponseEntity<String> cpfAlreadyExistsException(CpfAlreadyExistsException cpfAlreadyExistsException){
        return new ResponseEntity<>(cpfAlreadyExistsException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> bookNotFoundException(BookNotFoundException bookNotFoundException){
        return new ResponseEntity<>(bookNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NameAlreadyExistException.class)
    public ResponseEntity<String> nameAlreadyExistException(NameAlreadyExistException alreadyExistException){
        return new ResponseEntity<>(alreadyExistException.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AtorNotFoundException.class)
    public ResponseEntity<String> atorNotFoundException(AtorNotFoundException atorNotFoundException){
        return new ResponseEntity<>(atorNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<String> emailAlreadyExistException(EmailAlreadyExistException emailAlreadyExistException){
        return new ResponseEntity<>(emailAlreadyExistException.getMessage(), HttpStatus.CONFLICT);
    }

}
