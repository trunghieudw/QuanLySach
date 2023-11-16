package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Class;

public interface ClassService {
	Class saveClass(Class classes);

	List<Class> getAllClasses();

	Class getClassById(long id);

	Class updateClass(Class classes, long id);

	void deleteClass(long id);
	
    // Collection<Class> getClasses();
}
