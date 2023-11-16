package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.*;

public interface AuthorService {
	Author saveAuthor(Author author);
	
	List<Author> getAllAuthors();

	Author getAuthorById(long id);

	Author updateAuthor(Author author, long id);

	void deleteAuthor(long id);
}
