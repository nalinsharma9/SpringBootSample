package com.telusko.springjdbcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.telusko.springjdbcdemo.DAO.AlienDAO;
import com.telusko.springjdbcdemo.model.Alien;

@SpringBootApplication
public class SpringjdbcdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcdemoApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("Nalin");
		alien1.setTech("Java");

		AlienDAO dao = context.getBean(AlienDAO.class);
		dao.save(alien1);

		System.out.println(dao.findAll());
	}

}
