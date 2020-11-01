package com.scratchy.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
 
    @GetMapping("/")
    public String mainPage() {
        return "main-page";
    }

}