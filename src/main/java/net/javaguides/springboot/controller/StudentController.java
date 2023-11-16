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
@RequestMapping("/api/student")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// build create Student REST API
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	// build get all Students REST API
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	// build get Student by id REST API
	// http://localhost:8080/api/student/1
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
	}
	
	// build update Student REST API
	// http://localhost:8080/api/student/1
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id
												  ,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
	
	// build delete Student REST API
	// http://localhost:8080/api/student/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		
		// delete Student from DB
		studentService.deleteStudent(id);
		
		return new ResponseEntity<String>("Student deleted successfully!.", HttpStatus.OK);
	}
	
}
