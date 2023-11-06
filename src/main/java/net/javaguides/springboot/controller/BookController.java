package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.service.*;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	// build create User REST API
	@PostMapping()
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
	}
	
	// build get all Users REST API
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	// build get Book by id REST API
	// http://localhost:8080/api/Book/1
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") long bookId){
		return new ResponseEntity<Book>(bookService.getBookById(bookId), HttpStatus.OK);
	}
	
	// build update Book REST API
	// http://localhost:8080/api/Book/1
	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id
												  ,@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.updateBook(book, id), HttpStatus.OK);
	}
	
	// build delete Book REST API
	// http://localhost:8080/api/Book/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id){
		
		// delete Book from DB
		bookService.deleteBook(id);
		
		return new ResponseEntity<String>("Book deleted successfully!.", HttpStatus.OK);
	}
	
}
