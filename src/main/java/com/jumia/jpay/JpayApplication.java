package com.jumia.jpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JpayApplication {

	public static void main(String[] args) {
		System.out.println("Queres ver a rodar?");
		SpringApplication.run(JpayApplication.class, args);
	}

}
