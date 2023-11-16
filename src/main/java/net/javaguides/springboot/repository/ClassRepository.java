package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Class;

public interface ClassRepository extends JpaRepository<Class, Long>{

}
