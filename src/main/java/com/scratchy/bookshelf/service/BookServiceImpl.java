package com.scratchy.bookshelf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.scratchy.bookshelf.dao.BookDao;
import com.scratchy.bookshelf.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public Book getOne(String title) {
        return bookDao.getOne(title);
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    @Transactional
    public List<Book> getBooksByFilter(String filter) {
        return bookDao.getBooksByFilter(filter);
    }

    @Override
    @Transactional
    public List<Book> getAll(String author) {
        return bookDao.getAll(author);
    }

    @Override
    @Transactional
    public List<Book> getAll(List<String> genreList) {
        List<Book> selectedBooks = new ArrayList<>();

        if(noGenresChosen(genreList)) {
            selectedBooks = bookDao.getAll();
        } else {
            selectedBooks = bookDao.getAll(genreList);
        }
        return selectedBooks;
    }

    private boolean noGenresChosen(List<String> genreList) {
        return genreList == null;
    }

    @Override
    @Transactional
    public String add(Book newBook, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "construct-page";
        } else {
            bookDao.add(newBook);
            return "redirect:/";
        }
    }

    @Override
    @Transactional
    public void addAll(Collection<Book> bookCollection) {
        bookDao.addAll(bookCollection);
    }

    @Override
    @Transactional
    public Book delete(String title, int year) {
        return bookDao.delete(title, year);
    }
   
}