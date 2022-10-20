package com.cg.fms.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.cg.fms.dto.Booking;

public interface BookingService {
	

	public ResponseEntity<?> addBooking(Booking newBooking);
	
	public ResponseEntity<?> updateBooking(Booking changedBooking);
	
	public Iterable<Booking> displayAllBooking();
	
	public ResponseEntity<?> deleteBooking(BigInteger bookingId);
	
	public ResponseEntity<?> viewBookingById(BigInteger bookingId);
}
