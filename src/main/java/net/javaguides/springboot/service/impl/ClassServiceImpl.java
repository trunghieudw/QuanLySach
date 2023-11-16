package net.javaguides.springboot.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.*;

@Service
public class ClassServiceImpl implements ClassService{

	private ClassRepository classRepository;
	
	public ClassServiceImpl(ClassRepository classRepository) {
		super();
		this.classRepository = classRepository;
	}

	@Override
	public Class saveClass(Class clases) {
		return classRepository.save(clases);
	}

	@Override
	public List<Class> getAllClasses() {
		return classRepository.findAll();
	}
	@Override
	public Class getClassById(long id) {
		return classRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Class", "Id", id));
		
	}

	@Override
	public Class updateClass(Class clases, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Class existingClass = classRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Class", "Id", id)); 
		
		existingClass.setClassCode(clases.getClassCode());
		existingClass.setClassName(clases.getClassName());

		// save existing employee to DB
		classRepository.save(existingClass);
		return existingClass;
	}

	@Override
	public void deleteClass(long id) {
		
		// check whether a employee exist in a DB or not
		classRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Class", "Id", id));
		classRepository.deleteById(id);}






	
}
