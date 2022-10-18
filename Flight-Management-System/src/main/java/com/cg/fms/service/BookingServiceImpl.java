package com.cg.fms.service;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.cg.fms.dto.Booking;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.repository.BookingDao;



@Component
public class BookingServiceImpl implements BookingService{
	
	// Creating DAO Object
	
	@Autowired
	private BookingDao bookingDao;
	
	// Making new Booking
	@Override
	public ResponseEntity<Booking> addBooking(Booking newBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		try {
			if(!findBookingById.isPresent()) {
				bookingDao.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException("Booking with Booking ID: "+ newBooking.getBookingId() +" already exists!!");
		} catch(RecordAlreadyPresentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Updating Booking made
	
	@Override
	public Booking updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(changedBooking.getBookingId());
		if(findBookingById.isPresent()) {
			bookingDao.save(changedBooking);
		} else
			throw new RecordNotFoundException("Booking with Booking ID: "+ changedBooking.getBookingId() +" not exists!!");
		
		return changedBooking;
	}

	@Override
	public Iterable<Booking> displayAllBooking() {
		
		return bookingDao.findAll();
	}
	
	// Deleting the booking
	
	@Override
	public String deleteBooking(BigInteger bookingId) {
		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if(findBookingById.isPresent()) {
			bookingDao.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingId");
	}
	
	// Find booking by ID
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> viewBookingById(BigInteger bookingId) {
		Optional<Booking> findById = bookingDao.findById(bookingId);
		try {
			if(findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with Id "+ bookingId);
		} catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


}
