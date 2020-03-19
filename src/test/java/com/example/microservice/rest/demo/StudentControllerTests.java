package com.example.microservice.rest.demo;

import com.example.microservice.rest.demo.Controller.StudentController;
import com.example.microservice.rest.demo.Entity.Student;
import com.example.microservice.rest.demo.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import java.util.ArrayList;

@WebMvcTest (value = StudentController.class)
public class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void getAllStudentsTest() throws Exception
    {
        ArrayList<Student> mockStudent = new ArrayList<>();

        mockStudent.add(new Student(999,"mock999","course999"));
        Mockito.when(studentService.getAllStudents()).thenReturn(mockStudent);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        org.springframework.util.Assert.isTrue(result!=null,"bla");

    }
}
