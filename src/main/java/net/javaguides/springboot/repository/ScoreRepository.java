package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>{

}
