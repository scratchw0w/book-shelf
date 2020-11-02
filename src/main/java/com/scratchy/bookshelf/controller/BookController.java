package com.scratchy.bookshelf.controller;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;
import com.scratchy.bookshelf.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookManager;
 
    @GetMapping("/")
    public String mainPage() {
        // ?? 
        System.out.println(bookManager.getMany());
        System.out.println(bookManager.getOne("Vikings"));
        return "main-page";
    }

}