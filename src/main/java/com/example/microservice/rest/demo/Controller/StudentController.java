package com.example.microservice.rest.demo.Controller;

import com.example.microservice.rest.demo.Entity.Student;
import com.example.microservice.rest.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path="{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return  studentService.getStudentById(id);
    }

    //@RequestMapping(value="{id}",method = RequestMethod.DELETE)
    //@ResponseStatus(HttpStatus.OK)
    @DeleteMapping (path = "{id}")
    public void deleteStudentById(@PathVariable("id") int id){
          studentService.deleteStudentById(id);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @PostMapping
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }

}
