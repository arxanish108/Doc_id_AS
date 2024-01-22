package com.generateToken.generateToken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories
public class GenerateTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateTokenApplication.class, args);
	}
}
