package com.telusko.demo.bootjpa.dao;

import com.telusko.demo.bootjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository <Student, Integer>{
}
