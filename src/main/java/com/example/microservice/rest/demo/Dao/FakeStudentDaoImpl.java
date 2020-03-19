package com.example.microservice.rest.demo.Dao;

import com.example.microservice.rest.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fake")
public class FakeStudentDaoImpl implements IStudentDao {

    private static Map<Integer,Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Hagay1", "CS1"));
                put(2,new Student(2, "Hagay2", "CS2"));
                put(3,new Student(3, "Hagay3", "CS3"));

            }
        };
    }

    @Override
    public Collection<Student> getAllStudents()
    {
        return students.values();
    }

    @Override
    public Student getStudentById(int id){
        return  students.get(id);
    }

    @Override
    public void deleteStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        /*
        Student updateStudent = students.get(student.getId());
        updateStudent.setCourse(student.getCourse());
        updateStudent.setName(student.getName());
        */
        students.put(student.getId(),student);

    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(),student);
    }
}
