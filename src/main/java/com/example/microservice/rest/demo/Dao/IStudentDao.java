package com.example.microservice.rest.demo.Dao;

import com.example.microservice.rest.demo.Entity.Student;

import java.util.Collection;

public interface IStudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
