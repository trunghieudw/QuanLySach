package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.*;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Student", "Id", id));
		
	}

	@Override
	public Student updateStudent(Student student, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Student existingStudent = studentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Student", "Id", id)); 
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		// save existing employee to DB
		studentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(long id) {
		
		// check whether a employee exist in a DB or not
		studentRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Student", "Id", id));
		studentRepository.deleteById(id);
	}
	
}
