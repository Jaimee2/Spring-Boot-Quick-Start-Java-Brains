package com.JavaBrains.JavaBrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBrainsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBrainsApplication.class, args);
		System.out.println("Server initiated");
	}

}
