package com.example.SpringBootLivraria.controller;

import com.example.SpringBootLivraria.dto.BookRecordDto;
import com.example.SpringBootLivraria.model.BookModel;
import com.example.SpringBootLivraria.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody @Valid BookRecordDto bookRecordDto){
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(bookRecordDto, bookModel);

        bookService.save(bookModel);

        bookModel.add(linkTo(methodOn(BookController.class).findByIdBook(bookModel.getId())).withRel("Book:"));

        return ResponseEntity.status(HttpStatus.CREATED).body(bookModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> findByIdBook(@PathVariable(value = "id") UUID id){
        BookModel bookModel = bookService.findById(id);

        bookModel.add(linkTo(methodOn(BookController.class).findAllBooks()).withRel("Books List:"));

        return ResponseEntity.status(HttpStatus.OK).body(bookModel);
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> findAllBooks(){
        List<BookModel> bookModelList = bookService.findALl();

        if (!bookModelList.isEmpty()){
            for (BookModel bm: bookModelList){
                bm.add(linkTo(methodOn(BookController.class).findByIdBook(bm.getId())).withRel("Book:"));
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookModelList);
    }
}
