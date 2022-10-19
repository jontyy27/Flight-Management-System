package com.cg.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightManagementSystemApplication {

	public static void main(String[] args) {
		System.out.println("Inside Main Method");
		SpringApplication.run(FlightManagementSystemApplication.class, args);
		System.out.println("Outside Main method");
	}

}
