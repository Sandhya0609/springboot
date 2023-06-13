package com.sandhya.librarymanagement.service;

import com.sandhya.librarymanagement.model.Book;
import com.sandhya.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBook(Integer bookId) {
        return bookRepository.findById(bookId);

    }

    public Book addNewBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return true;
    }
    public Book updateBook(Integer bookId, Book updatebook){
        Book oldbook=this.bookRepository.findById(bookId).get();
        oldbook.setBookID(updatebook.getBookID());
        oldbook.setBookName(updatebook.getBookName());
        oldbook.setAuthor(updatebook.getAuthor());
        oldbook.setPrice(updatebook.getPrice());
        this.bookRepository.save(oldbook);
        return updatebook;}

}
