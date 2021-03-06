package com.cesur.hispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="models")
public class HispringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HispringApplication.class, args);
	}

}
