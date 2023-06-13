package com.sandhya.librarymanagement.repository;

import com.sandhya.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAll();
    Optional<Book> findById(Integer bookId);

    @Override
    void deleteById(Integer integer);
}

