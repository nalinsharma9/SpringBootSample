package com.telusko.demo.bootjpa.Service;

import com.telusko.demo.bootjpa.dao.StudentRepo;
import com.telusko.demo.bootjpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;
import java.util.Optional;

public class StudentService {
    @Autowired
    StudentRepo repo;

    public Student capitalizeName(int id){
        Optional<Student> studentOptional = repo.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            String name = student.getName();
            String modifiedName = capitalizeString(name);
            student.setName(modifiedName);
            return student;
        }else{
            return null;
        }
    }

    private String capitalizeString(String name){
        String modifiedName = name.toUpperCase(Locale.ENGLISH);
        return modifiedName;
    }

}
