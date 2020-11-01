package com.scratchy.bookshelf.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "books")
public class Book {
 
    @Id
    private String id;
    
    @Field(value = "title")
    private String title;

    @Field(value = "author")
    private String author;
    
    @Field(value = "year")
    private int year;

    @Field(value = "genre")
    private Genres genre;

    public Book() {}

    public Book(String title, String author, int year) {
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);
        if(Objects.requireNonNull(year) > 2020) 
            throw new IllegalArgumentException(year + " is greater than 2020");
        this.year = year;
    }

}