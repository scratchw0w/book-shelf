package com.scratchy.bookshelf.controller;

import com.scratchy.bookshelf.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookLibrary;

    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

}