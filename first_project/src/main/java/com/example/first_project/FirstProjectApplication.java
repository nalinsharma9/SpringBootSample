package com.example.first_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);

		//by default , Spring uses singleton scope. We can change the scope using @scope annotation
		Alien a1 = context.getBean(Alien.class);
		

		a1.show();
		
		
	}



}
