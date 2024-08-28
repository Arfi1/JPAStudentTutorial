package com.example.jpastudenttutorial.config;


import com.example.jpastudenttutorial.model.Student;
import com.example.jpastudenttutorial.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {


    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student[] students = {
                new Student("Alice", LocalDate.of(1999, 8, 15), LocalDateTime.of(11, 10, 2, 0, 0)),
                new Student("Bob", LocalDate.of(2000, 12, 2), LocalDateTime.of(11, 10, 2, 0, 0)),
                new Student("Charlie", LocalDate.of(2001, 5, 22), LocalDateTime.of(11, 10, 2, 0, 0))
        };


        try {
            int i = 0;

            while (i < students.length) {
                Student student = students[i];


                List<Student> existingStudent = studentRepository.findByName(student.getName());

                if (existingStudent.isEmpty()) {
                    studentRepository.save(student);
                    System.out.println("Gemte nyt student navn: " + student.getName());
                } else {
                    System.out.println("Studerende med dette navn: " + student.getName() + " Studerende med navn findes allerede");
                }
                i++;

            }
        } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
