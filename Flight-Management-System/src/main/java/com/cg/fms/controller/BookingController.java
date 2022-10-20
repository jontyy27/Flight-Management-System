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

import com.cg.fms.dto.Booking;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	

	// Add Booking

	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> addBooking(@RequestBody Booking newBooking) {
		return bookingService.addBooking(newBooking);
		
		
	}
	
	//Display all bookings
	@GetMapping("/displayAllBooking")
	public Iterable<Booking> readAllBookings(){
		return bookingService.displayAllBooking();
	}

	// Update booking
	@PutMapping("/updateBooking")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> modifyBooking(@RequestBody Booking updateBooking) {
		return bookingService.updateBooking(updateBooking);
		
	}
	
	// Search booking by ID
	@GetMapping("/searchBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") BigInteger bookingId){
		return bookingService.viewBookingById(bookingId);
	}
	
	// Delete booking by ID
	@DeleteMapping("/deleteBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> deleteBookingByID(@PathVariable("id") BigInteger bookingId) {
		return bookingService.deleteBooking(bookingId);
	
	}
}

