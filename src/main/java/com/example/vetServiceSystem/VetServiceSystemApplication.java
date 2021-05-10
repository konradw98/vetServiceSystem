package com.example.vetServiceSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class VetServiceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetServiceSystemApplication.class, args);
	}

}
