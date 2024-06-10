package com.telusko.demo.bootjpa.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.bootjpa.model.Alien;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien , Integer>{
    //jpa automatically creates the query for us if method name starts with "findBy or getBy" and
    //method name should end with the field name in the entity class
    List<Alien> findByTech(String tech);
    List<Alien> findByAidGreaterThan(int aid);

    //we can create custom queries using @Query annotation and JPQL
    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSorted(String tech);
}
