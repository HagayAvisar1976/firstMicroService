package com.example.microservice.rest.demo.Dao;

import com.example.microservice.rest.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("mongo")
public class MongoStudentImpl implements IStudentDao {

    private static Map<Integer,Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(11, "Mongo1", "CS1"));
                put(2,new Student(22, "Mongo2", "CS2"));
                put(3,new Student(33, "Mongo3", "CS3"));

            }
        };
    }
    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
