package com.example.SpringBookApp.Controller;


import com.example.SpringBookApp.Entity.Book;
import com.example.SpringBookApp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{bookID}")
    public ResponseEntity<Book> getBookByID(@PathVariable String bookID){
        return this.bookService.getBookByID(Integer.parseInt(bookID));
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    @PutMapping("/books/{bookID}")
    public ResponseEntity<Book> updateBook(@PathVariable int bookID, @RequestBody Book book){
        return this.bookService.updateBook(bookID, book);
    }

    @DeleteMapping("/book/{bookID}")
    public String deleteBookByID(@PathVariable String bookID){
        return this.bookService.deleteBook(Integer.parseInt(bookID));
    }

}
