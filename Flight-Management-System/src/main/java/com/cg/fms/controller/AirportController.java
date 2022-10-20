package com.cg.fms.controller;

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
import com.cg.fms.dto.Airport;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {
<<<<<<< HEAD
	
=======
	private static final Logger LOGGER=LoggerFactory.getLogger(AirportController.class);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	@Autowired(required = true)
	AirportService airportService;

	// View airport by ID
	@GetMapping("/viewAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> viewAirport(@PathVariable("id") String airportName) {
		return airportService.viewAirport(airportName);
=======
	public Airport viewAirport(@PathVariable("id") String airportCode) {
		LOGGER.info("inside class!!! AirportController, method!!!: viewAirport ");
		return airportService.viewAirport(airportCode);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
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
<<<<<<< HEAD
	public ResponseEntity<?> addAirport(@RequestBody Airport airport) {
		return airportService.addAirport(airport);
=======
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
		LOGGER.info("inside class!!! AirportController, method!!!: addAirport ");
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}

	// Update airport
	@PutMapping("/updateAirport")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> modifyAirport(@RequestBody Airport airport) {
		return airportService.modifyAirport(airport);
=======
	public ResponseEntity<Airport> modifyAirport(@RequestBody Airport airport) {
		airportService.modifyAirport(airport);
		LOGGER.info("inside class!!! AirportController, method!!!: modifyAirport ");
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}

	// Delete airport by ID
	@DeleteMapping("/deleteAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> removeAirport(@PathVariable("id") String airportName) {
		return airportService.removeAirport(airportName);
=======
	public String removeAirport(@PathVariable("id") String airportCode) {
		airportService.removeAirport(airportCode);
		LOGGER.info("inside class!!! AirportController, method!!!: removeAirport ");
		return "Airport "+airportCode+"is Deleted";
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}
}