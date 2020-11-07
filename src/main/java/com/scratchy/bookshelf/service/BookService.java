package com.scratchy.bookshelf.service;

import java.util.Collection;
import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

public interface BookService {

    Book getOne(String title);

    List<Book> getAll();

    List<Book> getAllByTitleOrAuthor(String bookMarker);

    List<Book> getAll(String author);

    List<Book> getAll(Genres genre);

    void add(Book newBook);

    void addAll(Collection<Book> bookCollection);

    Book delete(String title, int year);
    
}