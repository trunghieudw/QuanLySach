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
@RequestMapping("/api/author")
public class AuthorController {
	
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	// build create User REST API
	@PostMapping()
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
		return new ResponseEntity<Author>(authorService.saveAuthor(author), HttpStatus.CREATED);
	}
	
	// build get all Users REST API
	@GetMapping
	public List<Author> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	// build get Author by id REST API
	// http://localhost:8080/api/Author/1
	@GetMapping("{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable("id") long authorId){
		return new ResponseEntity<Author>(authorService.getAuthorById(authorId), HttpStatus.OK);
	}
	
	// build update Author REST API
	// http://localhost:8080/api/Author/1
	@PutMapping("{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") long id
												  ,@RequestBody Author author){
		return new ResponseEntity<Author>(authorService.updateAuthor(author, id), HttpStatus.OK);
	}
	
	// build delete Author REST API
	// http://localhost:8080/api/Author/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable("id") long id){
		
		// delete Author from DB
		authorService.deleteAuthor(id);
		
		return new ResponseEntity<String>("Author deleted successfully!.", HttpStatus.OK);
	}
	
}
