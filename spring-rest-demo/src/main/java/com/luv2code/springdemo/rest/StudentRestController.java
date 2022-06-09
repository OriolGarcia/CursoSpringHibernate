package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.rest.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){

         theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornimia","Patel"));
        theStudents.add(new Student("Mario","Rossi"));
        theStudents.add(new Student("Mary","Smith"));

    }
    @GetMapping("/students")
    public List<Student> getStudents() {


        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornimia","Patel"));
        theStudents.add(new Student("Mario","Rossi"));
        theStudents.add(new Student("Mary","Smith"));
        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        //
        if(studentId>= theStudents.size() || studentId<0){
                throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }
        // exeption handler

}
