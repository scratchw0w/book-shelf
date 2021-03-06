package com.scratchy.bookshelf.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private MongoTemplate dataBase;

    @Override
    public Book getOne(String title) {
        Book book = dataBase.findOne(Query.query(Criteria.where("title").is(title)), Book.class);

        if (book == null)
            throw new IllegalStateException("No book find with such parameters: title: " + title);
            
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = dataBase.findAll(Book.class);

        if (books.isEmpty())
            return Collections.emptyList();

        return books;
    }
    
    @Override
    public List<Book> getAll(String author) {
        List<Book> books = dataBase.find(Query.query(Criteria.where("author").is(author)), Book.class);
        
        if(books.isEmpty())
            return Collections.emptyList();

        return books;
    }

    @Override
    public void add(Book newBook) {
        dataBase.insert(Objects.requireNonNull(newBook), "library");
    }

    @Override
    public void addAll(Collection<Book> bookCollection) {
        if (bookCollection.isEmpty())
            return;
        
        for (Book newBook : bookCollection) {
            dataBase.insert(newBook, "library");
        }
    }

    @Override
    public Book delete(String title, int year) {
        Book deletedBook = dataBase.findOne(
            Query.query(Criteria.where("title").is(title).and("year").is(year)),
            Book.class);

        if(deletedBook == null)
            throw new IllegalArgumentException(
                "\nNo book find with such parameters: title: " +
                title + " and year: " + year);

        dataBase.remove(deletedBook);
        return deletedBook;
    }

    @Override
    public List<Book> getAll(List<String> genreList) {
        List<Book> detectedBooks = new ArrayList<>();
        for(String genre : genreList) {
            detectedBooks.addAll(
                getAll(Genres.valueOf(genre)));
        }

        if(detectedBooks.isEmpty())
            return List.of(Book.getUndefinedInstance("There are no books of this genre."));
        
        return detectedBooks;
    }

    private List<Book> getAll(Genres genre) {

        switch(genre) {
            case ACTION:
                return getBooksByGenre(Genres.ACTION);
			case ADVENTURE:
                return getBooksByGenre(Genres.ADVENTURE);
			case CLASSIC:
                return getBooksByGenre(Genres.CLASSIC);
			case COMEDY:
                return getBooksByGenre(Genres.COMEDY);
			case CRIME:
                return getBooksByGenre(Genres.CRIME);
			case DRAMA:
                return getBooksByGenre(Genres.DRAMA);
			case HORROR:
                return getBooksByGenre(Genres.HORROR);
			case POETRY:
			    return getBooksByGenre(Genres.POETRY);
			default:
				throw new IllegalStateException();
        }
    }

    private List<Book> getBooksByGenre(Genres genre) {
        return dataBase.find(Query.query(Criteria.where("genre").is(genre)), Book.class);
    }

    @Override
    public List<Book> getBooksByFilter(String filter) {
        return getDetectedBookList(filter);
    }

    private List<Book> getDetectedBookList(String bookTitleOrAuthor) {
        List<Book> detectedBooks = new ArrayList<>();

        detectedBooks = getDetectedBookListWithFlag(bookTitleOrAuthor, true);
        if(detectedBooks.isEmpty()) {
            detectedBooks = getDetectedBookListWithFlag(bookTitleOrAuthor, false);
        }
        if(detectedBooks.isEmpty()){
            detectedBooks = List.of(Book.getUndefinedInstance("The book cannot be found. Try again."));
        }
        return detectedBooks;
    }

    private List<Book> getDetectedBookListWithFlag(String bookTitleOrAuthor, boolean isTitle) {
        List<Book> detectedBooks = new ArrayList<>();
        
        if(isTitle) {
            detectedBooks = 
                dataBase.find(Query.query(Criteria.where("title").is(bookTitleOrAuthor)), Book.class);
        } else {
            detectedBooks =
                dataBase.find(Query.query(Criteria.where("author").is(bookTitleOrAuthor)), Book.class);
        }
        return detectedBooks;
    }
}