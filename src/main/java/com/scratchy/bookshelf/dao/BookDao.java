package com.scratchy.bookshelf.dao;

import java.util.Collection;
import java.util.List;

import com.scratchy.bookshelf.model.Book;

public interface BookDao {
    
    Book getOne(String title);

    List<Book> getAll(List<String> genreList);

    List<Book> getAll();

    List<Book> getBooksByFilter(String filter);

    List<Book> getAll(String author);

    void add(Book newBook);

    void addAll(Collection<Book> bookCollection);

    Book delete(String title, int year);
}