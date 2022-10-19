package com.cg.fms.controller;

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
	@Autowired(required = true)
	AirportService airportService;

	// View airport by ID
	@GetMapping("/viewAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airport viewAirport(@PathVariable("id") String airportCode) {
		return airportService.viewAirport(airportCode);
	}

	//View all airport
	@GetMapping("/allAirport")
	public Iterable<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
	}

	// Add new airport
	@PostMapping("/addAirport")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}

	// Update airport
	@PutMapping("/updateAirport")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Airport> modifyAirport(@RequestBody Airport airport) {
		airportService.modifyAirport(airport);
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}

	// Delete airport by ID
	@DeleteMapping("/deleteAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public String removeAirport(@PathVariable("id") String airportCode) {
		airportService.removeAirport(airportCode);
		return "Airport "+airportCode+"is Deleted";
	}
}