package com.scratchy.bookshelf.controller;

import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/search")
    public String searcher(@ModelAttribute(name = "bookParams") String bookTitleOrAuthor, Model theModel){
        List<Book> detectedBooks = bookLibrary.getAllByTitleOrAuthor(bookTitleOrAuthor);
        theModel.addAttribute("books", detectedBooks);
        return "search-page";
    }

    /*@GetMapping("/filter/{genre}")
    public String filmByGenrePage(@PathVariable("genre") String genreString, Model theModel) {
        Genres genre = Genres.valueOf(genreString.toUpperCase());
        List<Book> selectedBooks = bookLibrary.getAll(genre);
        theModel.addAttribute("books", selectedBooks);
        return "main-page";
    }*/

}