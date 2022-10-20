package com.cg.fms.controller;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Flight;
//RecordAlreadyPresentException;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired(required = true)
	FlightService flightService;

	// Add flight
	@PostMapping("/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	// View all flight
	@GetMapping("/allFlight")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	// View flight by ID
	@GetMapping("/viewFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	// Update flight
	@PutMapping("/updateFlight")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> modifyFlight(@RequestBody Flight flight) {
		return flightService.modifyFlight(flight);
	}

	// Delete flight by ID
	@DeleteMapping("/deleteFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> removeFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.removeFlight(flightNo);
	}
}