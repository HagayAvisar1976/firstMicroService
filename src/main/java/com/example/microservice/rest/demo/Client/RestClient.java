package com.example.microservice.rest.demo.Client;

import com.example.microservice.rest.demo.Entity.Student;
//import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestClient {

    private static final String GET_ALL_STUDENTS_ENDPOINT_URL = "http://localhost:8080/students";
    private static final String GET_ONE_STUDENT_ENDPOINT_URL = "http://localhost:8080/students/{id}";
    private static final String CREATE_STUDENT_ENDPOINT_URL = "http://localhost:8080/students/";
    //private static final String UPDATE_STUDENT_ENDPOINT_URL = "http://localhost:8080/students/1/{id}";


    private RestTemplate restTemplate;

    public RestClient() {
        this.restTemplate = new RestTemplate();
    }

    public void getAllStudents() {

        //Collection<Student> students;
        //HttpHeaders headers = new HttpHeaders();
        //HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        ResponseEntity<Student []> res = null;
        try {
             res = restTemplate.getForEntity(GET_ALL_STUDENTS_ENDPOINT_URL, Student[].class);
        }catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
        System.out.print(res.toString());
        //ResponseEntity <Student> res =  restTemplate.exchange(GET_ALL_STUDENTS_ENDPOINT_URL, HttpMethod.GET,Student.class);
    }

    public void getOneStudent(){

        Map< String, String > params = new HashMap<String, String>();
        params.put("id", "1");

        RestTemplate restTemplate = new RestTemplate();
        Student result = restTemplate.getForObject(GET_ONE_STUDENT_ENDPOINT_URL, Student .class, params);

        System.out.println(result);

    }

    public void createStudent(){
        Student student = new Student(5, "Hagay5", "course5");

        RestTemplate restTemplate = new RestTemplate();
        Student result = restTemplate.postForObject(CREATE_STUDENT_ENDPOINT_URL, student, Student.class);


        System.out.println(result);
    }

    public static void main(String[] args){
        RestClient client = new RestClient();

        client.createStudent();
        //client.getOneStudent();
        //client.getAllStudents();
    }
}
