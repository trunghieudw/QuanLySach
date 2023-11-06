package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.*;

@Service
public class AuthorServiceImpl implements AuthorService{

	private AuthorRepository authorRepository;
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthorById(long id) {
		return authorRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Author", "Id", id));
		
	}

	@Override
	public Author updateAuthor(Author author, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Author existingAuthor = authorRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Author", "Id", id)); 
		
		existingAuthor.setName(author.getName());
		// save existing employee to DB
		authorRepository.save(existingAuthor);
		return existingAuthor;
	}

	@Override
	public void deleteAuthor(long id) {
		
		// check whether a employee exist in a DB or not
		authorRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Author", "Id", id));
		authorRepository.deleteById(id);
	}
	
}
