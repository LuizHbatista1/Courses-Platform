package com.api.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.api.lessons , com.api.courses"})
public class LessonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonsApplication.class, args);
	}

}
