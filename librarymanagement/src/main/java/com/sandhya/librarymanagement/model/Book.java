package com.sandhya.librarymanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name="bookId")
    private Integer bookID;

    @Column(name="bookname")
    private String bookName;

    @Column(name="author")
    private  String author;

    @Column(name="price")
    private Integer price;

}
