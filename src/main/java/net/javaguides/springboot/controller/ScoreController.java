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
@RequestMapping("/api/score")
public class ScoreController {

    private ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        super();
        this.scoreService = scoreService;
    }

    // Build create Score REST API
    @PostMapping()
    public ResponseEntity<Score> saveScore(@RequestBody Score score) {
        return new ResponseEntity<Score>(scoreService.saveScore(score), HttpStatus.CREATED);
    }

    // Build get all Scores REST API
    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    // Build get Score by id REST API
    // http://localhost:8080/api/score/1
    @GetMapping("{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable("id") long scoreId) {
        return new ResponseEntity<Score>(scoreService.getScoreById(scoreId), HttpStatus.OK);
    }

    // Build update Score REST API
    // http://localhost:8080/api/score/1
    @PutMapping("{id}")
    public ResponseEntity<Score> updateScore(@PathVariable("id") long id,
                                             @RequestBody Score score) {
        return new ResponseEntity<Score>(scoreService.updateScore(score, id), HttpStatus.OK);
    }

    // Build delete Score REST API
    // http://localhost:8080/api/score/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteScore(@PathVariable("id") long id) {

        // Delete Score from DB
        scoreService.deleteScore(id);

        return new ResponseEntity<String>("Score deleted successfully!", HttpStatus.OK);
    }
}

