package com.cg.fms.controller;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.exception.ScheduledFlightNotFoundException;
import com.cg.fms.dto.ScheduledFlight;
import com.cg.fms.service.AirportService;
import com.cg.fms.service.FlightService;
import com.cg.fms.service.ScheduledFlightService;

@RestController
@RequestMapping("/scheduledFlight")

public class ScheduledFlightController {
	private static final Logger LOGGER=LoggerFactory.getLogger(ScheduledFlightController.class);
	
	 // Creating Service object
	 
	@Autowired
	ScheduledFlightService scheduleFlightService;

	@Autowired
	AirportService airportService;
	
	@Autowired
	FlightService flightService;

	 // Controller for adding Scheduled Flights
	 
	@PostMapping("/addSF")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addSF(@RequestBody ScheduledFlight newscheduleFlight) {
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: addSF ");
		return scheduleFlightService.addScheduledFlight(newscheduleFlight);
	}
	
	
	 // Controller for modifying existing Scheduled Flights
	
	@PutMapping("/modifySF")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<?> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: modifyScheduleFlight ");	
		return scheduleFlightService.updateScheduledFlight(scheduleFlight);
	}

	 // Controller for deleting existing Scheduled Flights
	
	@DeleteMapping("/deleteSF")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> deleteSF(@RequestParam BigInteger flightId)  {
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: deleteSF ");
		return scheduleFlightService.removeScheduledFlight(flightId);
	}

	
	 // Controller for viewing a Scheduled Flight by ID
	 
	@GetMapping("/searchSF/{id}")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<?> viewSF(@RequestParam BigInteger flightId) {
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: viewSF ");
		return scheduleFlightService.viewScheduledFlight(flightId);
	}

	 // Controller for viewing all Scheduled Flights
	 
	@GetMapping("/viewAll")
	public Iterable<ScheduledFlight> viewAllSF() {
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: viewAllSF ");
		return scheduleFlightService.viewAllScheduledFlights();
	}
}