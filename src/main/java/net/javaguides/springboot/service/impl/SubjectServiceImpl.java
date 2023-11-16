package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.service.*;
import net.javaguides.springboot.repository.*;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        super();
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(long id) {
        return subjectRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Subject", "Id", id));

    }

    @Override
    public Subject updateSubject(Subject subject, long id) {

        // Check whether a subject with the given id exists in the database or not
        Subject existingSubject = subjectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "Id", id));

        existingSubject.setSubjectName(subject.getSubjectName());
        // Save the existing subject to the database
        subjectRepository.save(existingSubject);
        return existingSubject;
    }

    @Override
    public void deleteSubject(long id) {

        // Check whether a subject exists in the database or not
        subjectRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Subject", "Id", id));
        subjectRepository.deleteById(id);
    }
}
