package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "class")
public class Class {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_code", nullable = false, unique = true)
    private String classCode;

    @Column(name = "class_name")
    private String className;
    
     // Thêm phương thức getter và setter cho id
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Thêm phương thức getter và setter cho classCode
    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    // Thêm phương thức getter và setter cho className
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
