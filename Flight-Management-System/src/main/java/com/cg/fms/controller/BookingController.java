package com.cg.fms.controller;

import java.math.BigInteger;

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

import com.cg.fms.dto.Booking;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBooking(@RequestBody Booking newBooking) {
		bookingService.addBooking(newBooking);
	}
	
	@GetMapping("/displayAllBooking")
	public Iterable<Booking> readAllBookings(){
		return bookingService.displayAllBooking();
	}


	@PutMapping("/updateBooking")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyBooking(@RequestBody Booking updateBooking) {
		bookingService.updateBooking(updateBooking);
	}
	
	@GetMapping("/searchBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") BigInteger bookingId){
		return bookingService.viewBookingById(bookingId);
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") BigInteger bookingId) {
		bookingService.deleteBooking(bookingId);
	}
}

