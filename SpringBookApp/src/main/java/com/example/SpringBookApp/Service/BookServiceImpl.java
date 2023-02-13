package com.example.SpringBookApp.Service;


import com.example.SpringBookApp.Dao.BookDao;
import com.example.SpringBookApp.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return this.bookDao.findAll();
    }

    @Override
    public ResponseEntity<Book> getBookByID(int bookID) {
        Book book = bookDao.findById(bookID).orElseThrow(()-> new RuntimeException("Book doesn't exist with that id"));
        return ResponseEntity.ok(book);
    }

    @Override
    public Book addBook(Book book) {
        return this.bookDao.save(book);
    }

    @Override
    public ResponseEntity<Book> updateBook(int id, Book book) {
        Book updateBook = bookDao.findById(id).orElseThrow(()-> new RuntimeException("Book doesn't exist with that id"));
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setIsbn(book.getIsbn());
        return ResponseEntity.ok(updateBook);
    }

    @Override
    public String deleteBook(int ID) {
        this.bookDao.deleteById(ID);
        return "Book with ID: "+ ID + " successfully deleted";
    }
}
