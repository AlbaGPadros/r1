package com.booksiread.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksiread.demo.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
List<Book> findByFiction(boolean fiction);

}
