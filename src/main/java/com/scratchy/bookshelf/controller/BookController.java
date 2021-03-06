package com.scratchy.bookshelf.controller;

import java.util.List;

import javax.validation.Valid;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
        ModelAndView modelView = new ModelAndView("main-page");
        List<Book> selectedBooks = bookLibrary.getAll(genreType);
        modelView.addObject("books", selectedBooks);
        return modelView;
    }

    @GetMapping("/delete")
    public String deleteBook(@ModelAttribute("title") String bookTitle,
            @ModelAttribute("year") String bookYear) {
        bookLibrary.delete(bookTitle, Integer.parseInt(bookYear));
        return "redirect:/";
    }

    @GetMapping("/constructor")
    public ModelAndView constructorPage(){
        ModelAndView modelView = new ModelAndView("construct-page");
        modelView.addObject("book", new Book());
        return modelView;
    }

    @PostMapping("/constructor")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook,
            BindingResult bindingResult) {
        return bookLibrary.add(theBook, bindingResult);
    }
}