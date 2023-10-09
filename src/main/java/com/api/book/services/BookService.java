package com.api.book.services;
import com.api.book.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(12,"Beginner of java","ABC"));
        list.add(new Book(34,"Beginner of C","PQR"));
        list.add(new Book(56,"Beginner of PYTHON","LMN"));
    }

    //get all books
    public List<Book> getAllBooks()
    {
        return list;
    }
    //get single book
    public Book getBookById(int id)
    {
      Book book = null;
      book = list.stream().filter(e->e.getId()==id).findFirst().get();
      return book;

    }
    //adding book
    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }

    //delete book
    public void deleteBook(int boo)
    {
        list.stream().filter(book -> book.getId()!=boo).collect(Collectors.toList());
    }
    //update book
    public void updateBook(Book book,int boo)
    {
        list = list.stream().map(b->{
            if (b.getId()==boo)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
