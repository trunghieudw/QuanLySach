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

    @Column(name = "score_value", nullable = false)
    private Double score;

    @ManyToOne
    @JoinColumn(name = "student_code", nullable = false,referencedColumnName = "student_code")
    private Student studentCode;

    @ManyToOne
    @JoinColumn(name = "subject_code", nullable = false,referencedColumnName = "subject_code")
    private Subject subjectCode;

}
