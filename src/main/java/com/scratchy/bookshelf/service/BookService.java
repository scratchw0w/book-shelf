package com.scratchy.bookshelf.service;

import java.util.Collection;
import java.util.List;

import com.scratchy.bookshelf.model.Book;

import org.springframework.validation.BindingResult;

public interface BookService {

    Book getOne(String title);

    List<Book> getAll();

    List<Book> getAll(List<String> genreList);

    List<Book> getBooksByFilter(String filter);

    List<Book> getAll(String author);

    String add(Book newBook, BindingResult bindingResult);

    void addAll(Collection<Book> bookCollection);

    Book delete(String title, int year);
    
}