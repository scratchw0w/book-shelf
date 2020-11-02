package com.scratchy.bookshelf.dao;

import java.util.List;

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


    // TODO format title!
    @Override
    public Book getOne(String title) {
        return dataBase.findOne(Query.query(Criteria.where("title").is(title)), Book.class);
    }

    @Override
    public List<Book> getMany() {
        return dataBase.findAll(Book.class);
    }

    @Override
    public void add(Book newBook) {
        dataBase.insert(newBook, "library");
    }

    @Override
    public Book delete(String title, int year) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getMany(Genres genre) {
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
        return dataBase.find(Query.query(Criteria.where("genre").is(genre.name())), Book.class);
    }
    
}