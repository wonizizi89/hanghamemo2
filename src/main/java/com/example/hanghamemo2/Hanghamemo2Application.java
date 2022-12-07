package com.example.hanghamemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hanghamemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hanghamemo2Application.class, args);
	}

}
