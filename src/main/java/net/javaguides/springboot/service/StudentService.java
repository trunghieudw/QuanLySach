package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.*;

public interface StudentService {
	Student saveStudent(Student Student);

	List<Student> getAllStudents();

	Student getStudentById(long id);

	Student updateStudent(Student Student, long id);

	void deleteStudent(long id);
}
