package com.example.jpastudenttutorial.repositories;

import com.example.jpastudenttutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

}
