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
@RequestMapping("/api/subject")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        super();
        this.subjectService = subjectService;
    }

    // Build create Subject REST API
    @PostMapping()
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        return new ResponseEntity<Subject>(subjectService.saveSubject(subject), HttpStatus.CREATED);
    }

    // Build get all Subjects REST API
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // Build get Subject by id REST API
    // http://localhost:8080/api/subject/1
    @GetMapping("{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") long subjectId) {
        return new ResponseEntity<Subject>(subjectService.getSubjectById(subjectId), HttpStatus.OK);
    }

    // Build update Subject REST API
    // http://localhost:8080/api/subject/1
    @PutMapping("{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable("id") long id,
                                                 @RequestBody Subject subject) {
        return new ResponseEntity<Subject>(subjectService.updateSubject(subject, id), HttpStatus.OK);
    }

    // Build delete Subject REST API
    // http://localhost:8080/api/subject/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") long id) {

        // Delete Subject from DB
        subjectService.deleteSubject(id);

        return new ResponseEntity<String>("Subject deleted successfully!", HttpStatus.OK);
    }
}

