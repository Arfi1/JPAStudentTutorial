package com.example.jpastudenttutorial.controller;

import com.example.jpastudenttutorial.model.Student;
import com.example.jpastudenttutorial.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/{name}")
    public List<Student> getAllStudents(@PathVariable String name) {
        return studentRepository.findAll();
    }


    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }


    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            studentRepository.save(student);
            return ResponseEntity.ok(student);
            // return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
            //return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");

        }
    }

}


