package com.example.jpastudenttutorial.repositories;

import com.example.jpastudenttutorial.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testOne() {
        List<Student> students = studentRepository.findByName("ca");
        //assertEquals(1, students.size());
        assertTrue(students.size()>0);
    }

}