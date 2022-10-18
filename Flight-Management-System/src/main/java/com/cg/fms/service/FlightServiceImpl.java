package com.cg.fms.service;


import com.cg.fms.exception.*;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.fms.repository.FlightDao;
//import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.dto.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;

	
	 // Adding a flight
	 
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		try {
		if (!findById.isPresent()) {
			flightDao.save(flight);
			return new ResponseEntity<Flight>(flight,HttpStatus.OK);
		} else
			throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
	}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightDao.findAll();
	}

	
	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
	    }
	
	@Override
	public Flight modifyFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightDao.save(flight);
		} else
			throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
		return flight;
	}

	
	public String removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			flightDao.deleteById(flightNumber);
			return "Flight removed!!";
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

	}
}