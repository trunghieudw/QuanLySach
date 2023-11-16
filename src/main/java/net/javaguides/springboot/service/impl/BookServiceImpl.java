package net.javaguides.springboot.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.*;

@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Book existingBook = bookRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Book", "Id", id)); 
		
		existingBook.setTitle(book.getTitle());
		existingBook.setPublishingCompany(book.getPublishingCompany());

		// save existing employee to DB
		bookRepository.save(existingBook);
		return existingBook;
	}

	@Override
	public void deleteBook(long id) {
		
		// check whether a employee exist in a DB or not
		bookRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Book", "Id", id));
		bookRepository.deleteById(id);
	}

	@Override
	public Book getBookById(long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getBookById'");
	}

	@Override
	public Collection<Book> getBooks() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getBooks'");
	}


	
}
