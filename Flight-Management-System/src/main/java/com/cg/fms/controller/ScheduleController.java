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
import com.cg.fms.dto.Schedule;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
<<<<<<< HEAD
	
=======
	private static final Logger LOGGER=LoggerFactory.getLogger(ScheduleController.class);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	@Autowired(required = true)
	ScheduleService scheduleService;


	// View schedule by ID

	@GetMapping("/viewSchedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> viewSchedule(@PathVariable("id") BigInteger scheduleId) {
=======
	public Schedule viewSchedule(@PathVariable("id") BigInteger scheduleId) {
		LOGGER.info("inside class!!! ScheduleController, method!!!: viewSchedule ");
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
		return scheduleService.viewSchedule(scheduleId);
	}

	// View all schedule

	@GetMapping("/allSchedule")
	public Iterable<Schedule> viewAllSchedule() {
		LOGGER.info("inside class!!! ScheduleController, method!!!: viewAllSchedule ");
		return scheduleService.viewAllSchedule();
	}


	// Add a schedule
	@PostMapping("/addSchedule")
	@ExceptionHandler(RecordAlreadyPresentException.class)
<<<<<<< HEAD
	public ResponseEntity<?> addSchedule(@RequestBody Schedule schedule) {
		return scheduleService.addSchedule(schedule);
=======
	public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
		scheduleService.addSchedule(schedule);
		LOGGER.info("inside class!!! ScheduleController, method!!!: addSchedule ");
		return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}


	// Update schedule
	@PutMapping("/updateSchedule")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> modifySchedule(@RequestBody Schedule schedule) {
		return scheduleService.modifySchedule(schedule);
=======
	public ResponseEntity<Schedule> modifySchedule(@RequestBody Schedule schedule) {
		scheduleService.modifySchedule(schedule);
		LOGGER.info("inside class!!! ScheduleController, method!!!: modifySchedule ");
		return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}


	// Delete schedule by ID
	@DeleteMapping("/deleteSchedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> removeSchedule(@PathVariable("id") BigInteger scheduleId) {
		return scheduleService.removeSchedule(scheduleId);
=======
	public String removeSchedule(@PathVariable("id") BigInteger scheduleId) {
		scheduleService.removeSchedule(scheduleId);
		LOGGER.info("inside class!!! ScheduleController, method!!!: removeSchedule ");
		return "The " + scheduleId + " has been deleted";
>>>>>>> 502f9732c65feab0ccc0a7be53773bb47c7a5a33
	}
}
