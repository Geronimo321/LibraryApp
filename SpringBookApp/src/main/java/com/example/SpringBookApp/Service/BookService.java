package com.example.SpringBookApp.Service;

import com.example.SpringBookApp.Entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    ResponseEntity<Book> getBookByID(int bookID);

    Book addBook(Book book);

    ResponseEntity<Book> updateBook(int id, Book book);

    String deleteBook(int ID);

}
