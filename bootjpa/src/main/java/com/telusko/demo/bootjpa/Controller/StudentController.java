package com.telusko.demo.bootjpa.Controller;

import com.telusko.demo.bootjpa.Service.StudentService;
import com.telusko.demo.bootjpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping(path = "/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        Student student = service.capitalizeName(id);
        if( student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

}
