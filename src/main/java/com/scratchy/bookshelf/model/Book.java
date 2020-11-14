package com.scratchy.bookshelf.model;

import java.util.Calendar;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "library")
public class Book {

    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

    @Id
    private String id;
    
    @Field(value = "title")
    @Pattern(regexp = "^[a-zA-Z0-9]{2,18}", message="Invalid title")
    private String title;

    @Field(value = "author")
    @Pattern(regexp = "^[a-zA-Z\\-]{2,18}", message = "Invalid author")
    private String author;
    
    @NotNull(message = "*")
    @Min(value = -4000, message = "Invalid year")
    @Max(value = 2020, message="Invalid year")
    @Field(value = "year")
    private Integer year;

    @Field(value = "genre")
    private Genres genre;

    public Book() {}

    public Book(String title, String author, int year, Genres genre) {
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);
        if(Objects.requireNonNull(year) > CURRENT_YEAR) 
            throw new IllegalArgumentException(year + " is greater than " + CURRENT_YEAR);
        this.year = year;
        this.genre = Objects.requireNonNull(genre);
    }

    private Book(String message) {
        this.title = Objects.requireNonNull(message);
    }

    public static Book getUndefinedInstance(String message) {
        return new Book(message);
    }

    @Override
    public String toString() {
        return "book: " + title + ", " + author + ", " + year + ", " + genre + "\n";
    }

}