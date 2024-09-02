package com.example.SpringBootLivraria.service.impl;

import com.example.SpringBootLivraria.exception.exceptions.BookNotFoundException;
import com.example.SpringBootLivraria.exception.exceptions.NameAlreadyExistException;
import com.example.SpringBootLivraria.model.BookModel;
import com.example.SpringBootLivraria.repository.BookRepository;
import com.example.SpringBootLivraria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public BookModel findById(UUID id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
    }

    @Override
    public List<BookModel> findALl() {

        if (bookRepository.findAll().isEmpty()){
            throw new BookNotFoundException("No Books found. Please ensure that there are books registered in the system.");
        }

        return bookRepository.findAll();
    }

    @Override
    public BookModel save(BookModel clientModel) {
        if (bookRepository.existsByNome(clientModel.getNome())){
            throw new NameAlreadyExistException("This book name already exist!");
        }

        return bookRepository.save(clientModel);
    }

    @Override
    public BookModel update(BookModel clientModel) {
        if (!bookRepository.existsById(clientModel.getId())){
            throw new BookNotFoundException("This Book id doesn't exist! " + clientModel.getId());
        }

        return bookRepository.save(clientModel);
    }

    @Override
    public void deleteById(UUID id) {
        if (!bookRepository.existsById(id)){
            throw new BookNotFoundException("This Book ID: " + id  + " doesn't exist!");
        }

        bookRepository.deleteById(id);
    }
}
