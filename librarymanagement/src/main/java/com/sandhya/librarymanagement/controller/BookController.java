package com.sandhya.librarymanagement.controller;

import com.sandhya.librarymanagement.model.Book;
import com.sandhya.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/book")
public class BookController {

    @Autowired
   private BookService bookService;


@GetMapping("/allBooks")
    public List<Book> getAllBooks(){
         return bookService.getAllBooks();
    }
}
