package com.telusko.demo.bootjpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.bootjpa.model.Alien;

public interface AlienRepo extends CrudRepository<Alien , Integer>{


}
