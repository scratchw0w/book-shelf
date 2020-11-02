package com.scratchy.bookshelf.service;

import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

public interface BookService {

    Book getOne(String title);

    List<Book> getMany();

    List<Book> getMany(Genres genre);

    void add(Book newBook);

    Book delete(String title, int year);
    
}