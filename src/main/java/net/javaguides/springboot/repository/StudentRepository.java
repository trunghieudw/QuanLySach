package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.*;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
