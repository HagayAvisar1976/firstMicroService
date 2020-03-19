package com.example.microservice.rest.demo;

import com.example.microservice.rest.demo.Entity.Student;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;




@SpringBootTest (classes = ExampleMicroserviceApplication.class, webEnvironment =   SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentRestIntegrationTests {

    @LocalServerPort
    private  int port;

    private TestRestTemplate testRestTemplate = new TestRestTemplate();
    private HttpHeaders httpHeaders = new HttpHeaders();

    @Test
    public void getAllStudentsTest(){

        HttpEntity<String> entity = new HttpEntity<String>(null,httpHeaders);

        String url = createURLWithPort("students");
        ResponseEntity<Student []> response = testRestTemplate.exchange(url,
                HttpMethod.GET,entity,Student[].class);

        //JSONAssert.
        org.springframework.util.Assert.isTrue(response !=null,"bla");

    }

    @Test
    public void insertStudentTest(){

        Student newStudent = new Student(55,"Hagay55","Course55");

        HttpEntity<Student> entity = new HttpEntity<Student>(newStudent,httpHeaders);

        String url = createURLWithPort("students");
        ResponseEntity<String> responseToAdd = testRestTemplate.exchange(url,
                HttpMethod.POST,entity,String.class);

        ResponseEntity<Student []> response = testRestTemplate.exchange(url,
                HttpMethod.GET,entity,Student[].class);

        org.springframework.util.Assert.isTrue(responseToAdd !=null,"bla");
        org.springframework.util.Assert.isTrue(response !=null,"bla");

    }

    private String createURLWithPort(String url)
    {
        return  String.format("http://localhost:%s/%s",port,url);
    }
}
