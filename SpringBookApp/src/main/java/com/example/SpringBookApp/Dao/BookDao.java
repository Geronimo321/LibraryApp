package com.example.SpringBookApp.Dao;

import com.example.SpringBookApp.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
}
