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
<<<<<<< HEAD
	
=======
	private static final Logger LOGGER=LoggerFactory.getLogger(FlightController.class);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	@Autowired(required = true)
	FlightService flightService;

	// Add flight
	@PostMapping("/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
<<<<<<< HEAD
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
=======
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
		LOGGER.info("inside class!!! FlightController, method!!!: addFlight ");
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
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
<<<<<<< HEAD
	public ResponseEntity<?> viewFlight(@PathVariable("id") BigInteger flightNo) {
=======
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		LOGGER.info("inside class!!! FlightController, method!!!: viewFlight ");
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
		return flightService.viewFlight(flightNo);
	}

	// Update flight
	@PutMapping("/updateFlight")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> modifyFlight(@RequestBody Flight flight) {
		return flightService.modifyFlight(flight);
=======
	public ResponseEntity<Flight> modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
		LOGGER.info("inside class!!! FlightController, method!!!: modifyFlight ");
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}

	// Delete flight by ID
	@DeleteMapping("/deleteFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> removeFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.removeFlight(flightNo);
=======
	public String removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
		LOGGER.info("inside class!!! FlightController, method!!!: removeFlight ");
		return "The Deleted Flight is "+flightNo;
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}
}