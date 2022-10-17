package com.cg.fms.service;

public interface BookingService {
	
<<<<<<< HEAD
=======
	public ResponseEntity<Booking> addBooking(Booking newBooking);
	
	public Booking updateBooking(Booking changedBooking);
	
	public Iterable<Booking> displayAllBooking();
	
	public String deleteBooking(BigInteger bookingId);
	
	public ResponseEntity<?> viewBookingById(BigInteger bookingId);
>>>>>>> 9a8fe8bd3155722b114f000994f993ec195fee13
}
