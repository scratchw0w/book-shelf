package com.scratchy.bookshelf.dao;

import java.util.List;

import com.scratchy.bookshelf.model.Book;
import com.scratchy.bookshelf.model.Genres;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public Book getOne(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getMany() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getMany(Genres genre) {
        
        /*switch(genre) {
            case ACTION:
                break;
			case ADVENTURE:
				break;
			case CLASSIC:
				break;
			case COMEDY:
				break;
			case CRIME:
				break;
			case DRAMA:
				break;
			case HORROR:
				break;
			case POETRY:
				break;
			default:
				break;
        } */
        
        return null;
    }

    @Override
    public void add(Book newBook) {
        // TODO Auto-generated method stub

    }

    @Override
    public Book delete(String title, int year) {
        // TODO Auto-generated method stub
        return null;
    }
    
}