package com.scratchy.bookshelf.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.scratchy.bookshelf.dao.BookDao;
import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class BookControllerIT {

    @Autowired
    BookDao bookRepository;

    @Test
    public void createBook_bookSaved(){
        Book book = new Book("TitleTest", "AuthorTest", 2020, Genres.ACTION);
        
        bookRepository.add(book);

        Book dbBook = bookRepository.getOne(book.getTitle());
        assertEquals(book.getTitle(), dbBook.getTitle());
        assertEquals(book.getAuthor(), dbBook.getAuthor());
        assertEquals(book.getYear(), dbBook.getYear());
        assertEquals(book.getGenre(), dbBook.getGenre());

    }

}
