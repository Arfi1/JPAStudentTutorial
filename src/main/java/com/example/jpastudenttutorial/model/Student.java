package com.example.jpastudenttutorial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate bornDate;
    private LocalDateTime bornTime;



    public Student (String name, LocalDate bornDate, LocalDateTime bornTime) {
        this.name = name;
        this.bornDate = bornDate;
        this.bornTime = bornTime;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public LocalDateTime getBornTime() {
        return bornTime;
    }

    public void setBornTime(LocalDateTime bornTime) {
        this.bornTime = bornTime;
    }
}
