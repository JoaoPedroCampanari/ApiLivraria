package com.example.SpringBootLivraria.service;


import com.example.SpringBootLivraria.model.BookModel;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookModel findById(UUID id);

    List<BookModel> findALl();

    BookModel save (BookModel clientModel);

    BookModel update(BookModel clientModel);

    void deleteById(UUID id);
}
