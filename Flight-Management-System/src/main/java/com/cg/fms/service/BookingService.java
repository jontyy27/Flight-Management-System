package com.cg.fms.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.cg.fms.dto.Booking;

public interface BookingService {
	

	public ResponseEntity<Booking> addBooking(Booking newBooking);
	
	public Booking updateBooking(Booking changedBooking);
	
	public Iterable<Booking> displayAllBooking();
	
	public String deleteBooking(BigInteger bookingId);
	
	public ResponseEntity<?> viewBookingById(BigInteger bookingId);
}
