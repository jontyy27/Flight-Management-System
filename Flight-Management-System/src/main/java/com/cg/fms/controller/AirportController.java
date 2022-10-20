package com.cg.fms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.fms.dto.Airport;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {

	private static final Logger LOGGER=LoggerFactory.getLogger(AirportController.class);

	@Autowired(required = true)
	AirportService airportService;

	// View airport by ID
	@GetMapping("/viewAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)

	public ResponseEntity<?> viewAirport(@PathVariable("id") String airportName) {
		LOGGER.info("inside class!!! AirportController, method!!!: viewAirport ");
		return airportService.viewAirport(airportName);	
	}

	//View all airport
	@GetMapping("/allAirport")
	public Iterable<Airport> viewAllAirport() {
		LOGGER.info("inside class!!! AirportController, method!!!: viewAllAirport ");
		return airportService.viewAllAirport();
	}

	// Add new airport
	@PostMapping("/addAirport")
	@ExceptionHandler(RecordAlreadyPresentException.class)

	public ResponseEntity<?> addAirport(@RequestBody Airport airport) {
		LOGGER.info("inside class!!! AirportController, method!!!: addAirport ");
		return airportService.addAirport(airport);
	}

	// Update airport
	@PutMapping("/updateAirport")
	@ExceptionHandler(RecordNotFoundException.class)

	public ResponseEntity<?> modifyAirport(@RequestBody Airport airport) {
		LOGGER.info("inside class!!! AirportController, method!!!: modifyAirport ");
		return airportService.modifyAirport(airport);
	}

	// Delete airport by ID
	@DeleteMapping("/deleteAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)

	public ResponseEntity<?> removeAirport(@PathVariable("id") String airportName) {
		LOGGER.info("inside class!!! AirportController, method!!!: removeAirport ");
		return airportService.removeAirport(airportName);
	}
}