package com.cg.fms.service;


import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.exception.ScheduledFlightNotFoundException;
import com.cg.fms.dto.ScheduledFlight;

public interface ScheduledFlightService {
	public ResponseEntity<?> addScheduledFlight(ScheduledFlight scheduledFlight);

	public ResponseEntity<?> updateScheduledFlight(ScheduledFlight scheduledFlight);

	public ResponseEntity<?> removeScheduledFlight(BigInteger id) throws RecordNotFoundException;

	public Iterable<ScheduledFlight> viewAllScheduledFlights();

	public ResponseEntity<?> viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
	
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}