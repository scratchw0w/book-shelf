package com.scratchy.bookshelf.service;

import java.util.List;

import com.scratchy.bookshelf.dao.BookDao;
import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao dataBase;

    @Override
    public Book getOne(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getMany() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getMany(Genres genre) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Book newBook) {
        // TODO Auto-generated method stub

    }

    @Override
    public Book delete(String title, int year) {
        // TODO Auto-generated method stub
        return null;
    }
    
}