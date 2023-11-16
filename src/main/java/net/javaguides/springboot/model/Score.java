package net.javaguides.springboot.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "score_value", nullable = false)
    private Double score;

    @ManyToOne
    @JoinColumn(name = "subject_code", nullable = false)
    private Subject subject;


}
