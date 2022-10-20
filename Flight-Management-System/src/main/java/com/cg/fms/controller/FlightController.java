package com.cg.fms.controller;


import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOGGER=LoggerFactory.getLogger(FlightController.class);

	@Autowired(required = true)
	FlightService flightService;

	// Add flight
	@PostMapping("/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		LOGGER.info("inside class!!! FlightController, method!!!: addFlight ");
		return flightService.addFlight(flight);
	}

	// View all flight
	@GetMapping("/allFlight")
	public Iterable<Flight> viewAllFlight() {
		LOGGER.info("inside class!!! FlightController, method!!!: viewAllFlight ");
		return flightService.viewAllFlight();
	}

	// View flight by ID
	@GetMapping("/viewFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> viewFlight(@PathVariable("id") BigInteger flightNo) {
		LOGGER.info("inside class!!! FlightController, method!!!: viewFlight ");
		return flightService.viewFlight(flightNo);
	}

	// Update flight
	@PutMapping("/updateFlight")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> modifyFlight(@RequestBody Flight flight) {
		LOGGER.info("inside class!!! FlightController, method!!!: modifyFlight ");
		return flightService.modifyFlight(flight);
	}

	// Delete flight by ID
	@DeleteMapping("/deleteFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> removeFlight(@PathVariable("id") BigInteger flightNo) {
		LOGGER.info("inside class!!! FlightController, method!!!: removeFlight ");
		return flightService.removeFlight(flightNo);
	}
}