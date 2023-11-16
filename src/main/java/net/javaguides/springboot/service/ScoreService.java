package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.*;

public interface ScoreService {
    Score saveScore(Score score);

    List<Score> getAllScores();

    Score getScoreById(long id);

    Score updateScore(Score score, long id);

    void deleteScore(long id);
}
