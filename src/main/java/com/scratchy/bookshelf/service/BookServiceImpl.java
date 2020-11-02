package com.scratchy.bookshelf.service;

import java.util.List;

import com.scratchy.bookshelf.dao.BookDao;
import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao dataBase;

    @Override
    @Transactional
    public Book getOne(String title) {
        return dataBase.getOne(title);
    }

    @Override
    @Transactional
    public List<Book> getMany() {
        return dataBase.getMany();
    }

    @Override
    @Transactional
    public List<Book> getMany(Genres genre) {
        return getMany(genre);
    }

    @Override
    @Transactional
    public void add(Book newBook) {
        dataBase.add(newBook);
    }

    @Override
    @Transactional
    public Book delete(String title, int year) {
        return dataBase.delete(title, year);
    }
    
}