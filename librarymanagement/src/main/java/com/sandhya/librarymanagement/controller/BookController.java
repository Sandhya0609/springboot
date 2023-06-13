package com.sandhya.librarymanagement.controller;

import com.sandhya.librarymanagement.model.Book;
import com.sandhya.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{bookId}")
    public Optional<Book> getBook(@PathVariable Integer bookId) {
        return bookService.getBook(bookId);

    }
    @PostMapping("/addNewBook")
    public Book addNewBook(@RequestBody Book book){
        return bookService.addNewBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public boolean deleteBook(@PathVariable Integer bookId){
        bookService.deleteBook(bookId);
        return true;
    }

    @PutMapping("/update/{bookId}")
    public Book updateBook(@PathVariable Integer bookId,@RequestBody Book updateBook){
        return bookService.updateBook(bookId,updateBook);
    }
}
