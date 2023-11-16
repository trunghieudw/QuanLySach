package net.javaguides.springboot.service;

import java.util.Collection;
import java.util.List;

import net.javaguides.springboot.model.*;

public interface BookService {
	Book saveBook(Book book);

	List<Book> getAllBooks();

	Book getBookById(long id);

	Book updateBook(Book book, long id);

	void deleteBook(long id);
	
    Collection<Book> getBooks();
}
