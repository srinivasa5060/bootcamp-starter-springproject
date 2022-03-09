package com.tmo.bootcamp.simplespringbootservice.controller;
import com.tmo.bootcamp.simplespringbootservice.model.Book;
import com.tmo.bootcamp.simplespringbootservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/api/books")
    public ResponseEntity<Book> addBooks(@RequestBody Book book) {
        book =repository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);}

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<String> removeBooks() {
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
