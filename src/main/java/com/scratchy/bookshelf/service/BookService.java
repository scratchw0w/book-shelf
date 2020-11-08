package com.scratchy.bookshelf.service;

import java.util.Collection;
import java.util.List;

import com.scratchy.bookshelf.model.Book;

public interface BookService {

    Book getOne(String title);

    List<Book> getAll();

    List<Book> getAll(List<String> genreList);

    List<Book> getBooksByFilter(String filter);

    List<Book> getAll(String author);

    void add(Book newBook);

    void addAll(Collection<Book> bookCollection);

    Book delete(String title, int year);
    
}