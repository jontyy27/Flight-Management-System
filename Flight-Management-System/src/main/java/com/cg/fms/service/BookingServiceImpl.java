package com.cg.fms.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.fms.dto.Booking;
import com.cg.fms.repository.BookingDao;

@Component
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDao bookingDao;

	@Override
	public ResponseEntity<Booking> addBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking updateBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Booking> displayAllBooking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBooking(BigInteger bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> viewBookingById(BigInteger bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

}
