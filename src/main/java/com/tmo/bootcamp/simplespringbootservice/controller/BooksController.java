package com.tmo.bootcamp.simplespringbootservice.controller;

import com.tmo.bootcamp.simplespringbootservice.model.Book;
import com.tmo.bootcamp.simplespringbootservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BooksController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/api/books")
    public ResponseEntity<Book> addBooks(@RequestBody Book book) {
        return new ResponseEntity<>(repository.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/api/books")
    public ResponseEntity<Map> getAllBooks() {
        Map<String, List<Book>> books = new HashMap();
        books.put("books", repository.findAll());
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<String> removeBooks() {
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
