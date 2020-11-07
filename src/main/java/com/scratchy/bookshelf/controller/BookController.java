package com.scratchy.bookshelf.controller;

import java.util.ArrayList;
import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;
import com.scratchy.bookshelf.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookLibrary;

    @GetMapping("/")
    public String mainPage(Model theModel) {
        List<Book> allBooks = bookLibrary.getAll();
        theModel.addAttribute("books", allBooks);
        return "main-page";
    }

    @PostMapping("/")
    public String searcher(@ModelAttribute(name = "bookParams") String bookTitleOrAuthor, Model theModel) {
        List<Book> detectedBooks = bookLibrary.getAllByTitleOrAuthor(bookTitleOrAuthor);
        theModel.addAttribute("books", detectedBooks);
        return "main-page";
    }

    @GetMapping("/filter")
    public String mainPageAfterSorting(@RequestParam(required = false) List<String> genreType, Model theModel) {
        List<Book> selectedBooks = new ArrayList<>();

        if(genreType == null) {
            selectedBooks = bookLibrary.getAll();
            theModel.addAttribute("books", selectedBooks);
            return "main-page";
        }

        Genres choosedGenre;
        for(String genre : genreType) {
            choosedGenre = Genres.valueOf(genre);
            selectedBooks.addAll(bookLibrary.getAll(choosedGenre));
        }
        
        theModel.addAttribute("books", selectedBooks);
        return "main-page";
    }

}