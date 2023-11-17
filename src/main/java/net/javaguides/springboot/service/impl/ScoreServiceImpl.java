package net.javaguides.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.service.*;
import net.javaguides.springboot.repository.*;

@Service
public class ScoreServiceImpl implements ScoreService {

    private ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        super();
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public Score getScoreById(long id) {
        return scoreRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Score", "Id", id));
    }

    @Override
    public Score updateScore(Score score, long id) {
        // Check whether a score with the given id exists in the database or not
        Score existingScore = scoreRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Score", "Id", id));

        existingScore.setScore(score.getScore());
        existingScore.setStudentCode(score.getStudentCode());
        existingScore.setSubjectCode(score.getSubjectCode());

        // Save the existing score to the database
        scoreRepository.save(existingScore);
        return existingScore;
    }

    @Override
    public void deleteScore(long id) {
        // Check whether a score exists in the database or not
        scoreRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Score", "Id", id));
        scoreRepository.deleteById(id);
    }
}
