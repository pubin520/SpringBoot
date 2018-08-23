package com.ddtech.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Spring04TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring04TaskApplication.class, args);
	}
}
