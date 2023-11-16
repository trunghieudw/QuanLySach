package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Subject;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    List<Subject> getAllSubjects();

    Subject getSubjectById(long id);

    Subject updateSubject(Subject subject, long id);

    void deleteSubject(long id);
}
