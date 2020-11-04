package com.scratchy.bookshelf.dao;

import java.util.Collection;
import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

public interface BookDao {
    
    Book getOne(String title);

    List<Book> getAll();

    List<Book> getAll(String author);

    List<Book> getAll(Genres genre);

    void add(Book newBook);

    void addAll(Collection<Book> bookCollection);

    Book delete(String title, int year);
}