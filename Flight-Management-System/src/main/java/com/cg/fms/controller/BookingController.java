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

import com.cg.fms.dto.Booking;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	private static final Logger LOGGER=LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	BookingService bookingService;
	

	// Add Booking

	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
<<<<<<< HEAD
	public ResponseEntity<?> addBooking(@RequestBody Booking newBooking) {
		return bookingService.addBooking(newBooking);
		
		
=======
	public ResponseEntity<Booking> addBooking(@RequestBody Booking newBooking) {
		System.out.println("inside create booking");
		bookingService.addBooking(newBooking);
		LOGGER.info("inside class!!! BookingController, method!!!: addBooking ");
		return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
>>>>>>> b0338f8f9c6beef41fe3ae3fe8f7f2fa012a4dec
	}
	
	//Display all bookings
	@GetMapping("/displayAllBooking")
	public Iterable<Booking> readAllBookings(){
		LOGGER.info("inside class!!! BookingController, method!!!: readAllBookings ");
		return bookingService.displayAllBooking();
	}

	// Update booking
	@PutMapping("/updateBooking")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> modifyBooking(@RequestBody Booking updateBooking) {
		return bookingService.updateBooking(updateBooking);
		
=======
	public ResponseEntity<Booking> modifyBooking(@RequestBody Booking updateBooking) {
		bookingService.updateBooking(updateBooking);
		LOGGER.info("inside class!!! BookingController, method!!!: modifyBooking ");
		return new ResponseEntity<Booking>(updateBooking, HttpStatus.OK);
>>>>>>> b0338f8f9c6beef41fe3ae3fe8f7f2fa012a4dec
	}
	
	// Search booking by ID
	@GetMapping("/searchBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") BigInteger bookingId){
		LOGGER.info("inside class!!! BookingController, method!!!: searchBookingByID ");
		return bookingService.viewBookingById(bookingId);
	}
	
	// Delete booking by ID
	@DeleteMapping("/deleteBooking/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
<<<<<<< HEAD
	public ResponseEntity<?> deleteBookingByID(@PathVariable("id") BigInteger bookingId) {
		return bookingService.deleteBooking(bookingId);
	
=======
	public String deleteBookingByID(@PathVariable("id") BigInteger bookingId) {
		bookingService.deleteBooking(bookingId);
		LOGGER.info("inside class!!! BookingController, method!!!: deleteBookingByID ");
		return "The Booking is deleted for Booking ID :"+bookingId;
>>>>>>> b0338f8f9c6beef41fe3ae3fe8f7f2fa012a4dec
	}
}

