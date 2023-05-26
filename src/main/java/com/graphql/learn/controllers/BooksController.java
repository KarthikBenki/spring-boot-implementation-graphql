package com.graphql.learn.controllers;


import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;


    //create


    @PostMapping("/create")
    public Book create(@RequestBody Book book) {
        Book b=new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }

    //get all

    @GetMapping()
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    //get single book
    @GetMapping("/{bookId}")
    public Book get(@PathVariable int bookId) {
        return this.bookService.get(bookId);
    }


}
