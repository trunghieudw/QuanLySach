package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.service.*;

@RestController
@RequestMapping("/api/class")
public class ClassController {
	
	private ClassService classService;

	public ClassController(ClassService classService) {
		super();
		this.classService = classService;
	}
	
	// build create User REST API
	@PostMapping()
	public ResponseEntity<Class> saveClass(@RequestBody Class clases){
		return new ResponseEntity<Class>(classService.saveClass(clases), HttpStatus.CREATED);
	}
	
	// build get all Users REST API
	@GetMapping
	public List<Class> getAllClasss(){
		return classService.getAllClasses();
	}
	@GetMapping("/viewClasss")
    public String viewClasss(Model model) {
        model.addAttribute("classs", classService.getAllClasses());
        return "view-classs";
    }
	
	// build get Class by id REST API
	// http://localhost:8080/api/class/1
	@GetMapping("{id}")
	public ResponseEntity<Class> getClassById(@PathVariable("id") long classId){
		return new ResponseEntity<Class>(classService.getClassById(classId), HttpStatus.OK);
	}
	
	// build update Class REST API
	// http://localhost:8080/api/class/1
	@PutMapping("{id}")
	public ResponseEntity<Class> updateClass(@PathVariable("id") long id
												  ,@RequestBody Class clases){
		return new ResponseEntity<Class>(classService.updateClass(clases, id), HttpStatus.OK);
	}
	
	// build delete Class REST API
	// http://localhost:8080/api/class/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClass(@PathVariable("id") long id){
		
		// delete Class from DB
		classService.deleteClass(id);
		
		return new ResponseEntity<String>("Class deleted successfully!.", HttpStatus.OK);
	}
	
}
