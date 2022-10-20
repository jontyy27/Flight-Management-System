package com.cg.fms.service;


import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.dto.Flight;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.repository.FlightDao;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;

	
	 // Adding a flight
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> addFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		try {
		if (findById.isPresent()) {
			throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
		}else {
			flightDao.save(flight);
			return new ResponseEntity<Flight>(flight, HttpStatus.OK);
		} 		
	}catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// viewing all flight
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightDao.findAll();
	}

	// view flight by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<?> viewFlight(BigInteger flightNo) {
		Optional<Flight> findById = flightDao.findById(flightNo);
		try {
			if (findById.isPresent()) {
				Flight findFlight = findById.get();
				return new ResponseEntity<Flight>(findFlight, HttpStatus.OK);
			}else
				throw new RecordNotFoundException("Flight with number: " + flightNo + " not exists");
		}catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}
	
	// modify flight
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<?> modifyFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		try {
			if (findById.isPresent()) {
				flightDao.save(flight);
				return new ResponseEntity<Flight>(flight, HttpStatus.OK);
			}else
				throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
		} catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}

	// delete flight by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<?> removeFlight(BigInteger flightNo) {
		Optional<Flight> findById = flightDao.findById(flightNo);
		try {
			if(findById.isPresent()) {
				Flight deleteId = findById.get();
				flightDao.deleteById(flightNo);
				return new ResponseEntity<Flight>(deleteId, HttpStatus.OK);
			}else
				throw new RecordNotFoundException("Flight with number: " + flightNo + " not exists");
		} catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
}