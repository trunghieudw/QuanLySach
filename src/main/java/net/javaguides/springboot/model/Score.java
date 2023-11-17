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

    
    @Column(name = "student_code", nullable = false)
    private String studentCode;

  
    @Column(name = "subject_code", nullable = false)
    private String subjectCode;

    // Thêm phương thức getter và setter cho id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Thêm phương thức getter và setter cho score
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    // Thêm phương thức getter và setter cho studentCode
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    // Thêm phương thức getter và setter cho subjectCode
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
