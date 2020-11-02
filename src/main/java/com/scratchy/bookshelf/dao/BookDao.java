package com.scratchy.bookshelf.dao;

import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

public interface BookDao {
    
    Book getOne(String title);

    List<Book> getMany();

    List<Book> getMany(Genres genre);

    void add(Book newBook);

    Book delete(String title, int year);
}