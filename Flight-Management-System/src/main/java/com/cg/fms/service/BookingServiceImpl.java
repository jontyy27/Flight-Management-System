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
import com.cg.fms.secure.model.User;

@Component
public class BookingServiceImpl implements BookingService{
	
	// Creating DAO Object
	
	@Autowired
	private BookingDao bookingDao;
	
	// Making new Booking
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> addBooking(Booking newBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		try {
			if(!findBookingById.isPresent()) {
				throw new RecordAlreadyPresentException("Booking with Booking ID: "+ newBooking.getBookingId() +" already exists!!");

			} else {
				bookingDao.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			}
		} catch(RecordAlreadyPresentException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// Updating Booking made
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookingDao.findById(changedBooking.getBookingId());
		try {
		if(findBookingById.isPresent()) {
			bookingDao.save(changedBooking);
			return new ResponseEntity<Booking>(changedBooking, HttpStatus.OK);
		} else {
			throw new RecordNotFoundException("Booking with Booking ID: "+ changedBooking.getBookingId() +" not exists!!");
		}
		}catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	// Displaying all booking
	
	@Override
	public Iterable<Booking> displayAllBooking() {
		return bookingDao.findAll();
	}
	
	// Deleting the booking
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> deleteBooking(BigInteger bookingId) {
		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		try {
		if(findBookingById.isPresent()) {
			Booking deleteId= findBookingById.get();
			bookingDao.deleteById(bookingId);
			return new ResponseEntity<Booking>(deleteId, HttpStatus.OK);
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingId");
	}catch(RecordNotFoundException e) {
		return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
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
