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
import com.cg.fms.dto.Schedule;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired(required = true)
	ScheduleService scheduleService;


	// View schedule by ID

	@GetMapping("/viewSchedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> viewSchedule(@PathVariable("id") BigInteger scheduleId) {
		return scheduleService.viewSchedule(scheduleId);
	}

	// View all schedule

	@GetMapping("/allSchedule")
	public Iterable<Schedule> viewAllSchedule() {
		return scheduleService.viewAllSchedule();
	}


	// Add a schedule
	@PostMapping("/addSchedule")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addSchedule(@RequestBody Schedule schedule) {
		return scheduleService.addSchedule(schedule);
	}


	// Update schedule
	@PutMapping("/updateSchedule")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> modifySchedule(@RequestBody Schedule schedule) {
		return scheduleService.modifySchedule(schedule);
	}


	// Delete schedule by ID
	@DeleteMapping("/deleteSchedule/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> removeSchedule(@PathVariable("id") BigInteger scheduleId) {
		return scheduleService.removeSchedule(scheduleId);
	}
}
