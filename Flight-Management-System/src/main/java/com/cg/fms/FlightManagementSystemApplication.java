package com.cg.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightManagementSystemApplication {

	public static void main(String[] args) {
		System.out.println("Inside main method");
		SpringApplication.run(FlightManagementSystemApplication.class, args);
		System.out.println("Outside main method");
	}

}
