package com.scratchy.bookshelf.controller;

import java.util.ArrayList;
import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;
import com.scratchy.bookshelf.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookLibrary;

    @GetMapping("/")
    public ModelAndView mainPage() {
        List<Book> allBooks = bookLibrary.getAll();
        ModelAndView modelView = new ModelAndView("main-page");
        modelView.addObject("books", allBooks);
        return modelView;
    }

    @PostMapping("/")
    public ModelAndView searcher(@ModelAttribute(name = "bookParams") String bookTitleOrAuthor) {
        List<Book> detectedBooks = bookLibrary.getBooksByFilter(bookTitleOrAuthor);
        ModelAndView modelView = new ModelAndView("main-page");
        modelView.addObject("books", detectedBooks);
        return modelView;
    }

    @GetMapping("/filter")
    public ModelAndView mainPageAfterSorting(@RequestParam(required = false) List<String> genreType) {
        List<Book> selectedBooks = new ArrayList<>();
        ModelAndView modelView = new ModelAndView("main-page");

        if(genreType == null) {
            selectedBooks = bookLibrary.getAll();
            modelView.addObject("books", selectedBooks);
            return modelView;
        }
        Genres choosedGenre;
        for(String genre : genreType) {
            choosedGenre = Genres.valueOf(genre);
            selectedBooks.addAll(bookLibrary.getAll(choosedGenre));
        }
        
        modelView.addObject("books", selectedBooks);
        return modelView;
    }

}