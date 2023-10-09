package com.api.book.controller;

import com.api.book.entity.Book;
import com.api.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List<Book> getBooks()
    {

        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return bookService.getBookById(id);
    }
    //create new book handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        Book b = this.bookService.addBook(book);
        return b;
    }

    //delete book handler
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId)
    {
       this.bookService.deleteBook(bookId);
    }

    //update book handler
    @PutMapping("/books/{bid}")
    public void updateBook(@RequestBody Book book,@PathVariable("bid") int bid)
    {
        this.bookService.updateBook(book,bid);
    }

}
