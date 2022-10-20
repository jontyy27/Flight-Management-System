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
import com.cg.fms.dto.Schedule;
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
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	

	@PostMapping("/addSF")
<<<<<<< HEAD
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addSF(@RequestBody ScheduledFlight newscheduleFlight) {
		return scheduleFlightService.addScheduledFlight(newscheduleFlight);

=======
	public ResponseEntity<ScheduledFlight> addSF(@RequestBody ScheduledFlight newscheduleFlight) {
		scheduleFlightService.addScheduledFlight(newscheduleFlight);
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: addSF ");
		return new ResponseEntity<ScheduledFlight>(newscheduleFlight, HttpStatus.OK);
>>>>>>> b0338f8f9c6beef41fe3ae3fe8f7f2fa012a4dec

	}
	
	
	/*
	@PostMapping("/addSF")
	public ResponseEntity<ScheduledFlight> addSF(@RequestBody ScheduledFlight scheduledFlight,

	
	 // Controller for adding Scheduled Flights
	  
	@ExceptionHandler(RecordAlreadyPresentException.class)
	@PostMapping("/addSF")
	public ResponseEntity<ScheduledFlight> addSF(@RequestBody ScheduledFlight scheduledFlight,
			@RequestParam(name = "srcAirport") String source, @RequestParam(name = "dstnAirport") String destination,
			@RequestParam(name = "deptDateTime") String departureTime, @RequestParam(name = "arrDateTime") String arrivalTime) {
		System.out.println("Inside controller");
		Schedule schedule = new Schedule();
		scheduledFlight.getSchedule().getDstnAirport();
		System.out.println(scheduledFlight.getSchedule().getDstnAirport());
		schedule.setScheduleId(scheduledFlight.getScheduleFlightId());
		try {
			schedule.setSrcAirport(airportService.viewAirport(source));
		} catch(RecordNotFoundException e) {
			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
		}
		
		try {
			schedule.setDstnAirport(airportService.viewAirport(destination));
		} catch (RecordNotFoundException e) {
			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
		}
		schedule.setDeptDateTime(departureTime);
		schedule.setArrDateTime(arrivalTime);
		
		try {
			scheduledFlight.setFlight(flightService.viewFlight(scheduledFlight.getScheduleFlightId()));
		} catch (RecordNotFoundException e1) {
			return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
		}
		scheduledFlight.setSchedule(schedule);
		scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
		
		try {
			return new ResponseEntity<ScheduledFlight>(scheduleFlightService.addScheduledFlight(scheduledFlight),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
		}
	}
*/
	
	 // Controller for modifying existing Scheduled Flights
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/modifySF")
<<<<<<< HEAD
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<?> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
			return scheduleFlightService.updateScheduledFlight(scheduleFlight);
			
=======
	public ResponseEntity<ScheduledFlight> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
		ScheduledFlight modifySFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		if (modifySFlight == null) {
			LOGGER.info("inside class!!! ScheduledFlightController, method!!!: modifyScheduleFlight ");
			return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			LOGGER.info("inside class!!! ScheduledFlightController, method!!!: modifyScheduleFlight ");
			return new ResponseEntity<ScheduledFlight>(modifySFlight, HttpStatus.OK);
		}
>>>>>>> b0338f8f9c6beef41fe3ae3fe8f7f2fa012a4dec
	}

	 // Controller for deleting existing Scheduled Flights
	
	@DeleteMapping("/deleteSF")
<<<<<<< HEAD
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> deleteSF(@RequestParam BigInteger flightId)  {
=======
	public String deleteSF(@RequestParam BigInteger flightId) throws RecordNotFoundException {
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: deleteSF ");
>>>>>>> b0338f8f9c6beef41fe3ae3fe8f7f2fa012a4dec
		return scheduleFlightService.removeScheduledFlight(flightId);
	}

	
	 // Controller for viewing a Scheduled Flight by ID
	 

	@GetMapping("/searchSF/{id}")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> viewSF(@RequestParam BigInteger flightId) {
		return scheduleFlightService.viewScheduledFlight(flightId);
=======
	public ResponseEntity<ScheduledFlight> viewSF(@RequestParam BigInteger flightId) throws ScheduledFlightNotFoundException {
		ScheduledFlight searchSFlight = scheduleFlightService.viewScheduledFlight(flightId);
		if (searchSFlight == null) {
			LOGGER.info("inside class!!! ScheduledFlightController, method!!!: viewSF ");
			return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("inside class!!! ScheduledFlightController, method!!!: viewSF ");
			return new ResponseEntity<ScheduledFlight>(searchSFlight, HttpStatus.OK);
		}
>>>>>>> b0338f8f9c6beef41fe3ae3fe8f7f2fa012a4dec
	}

	 // Controller for viewing all Scheduled Flights
	 
	@GetMapping("/viewAll")
	public Iterable<ScheduledFlight> viewAllSF() {
		LOGGER.info("inside class!!! ScheduledFlightController, method!!!: viewAllSF ");
		return scheduleFlightService.viewAllScheduledFlights();
	}
}