package com.cg.fms.service;


import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.cg.fms.dto.Flight;

public interface FlightService {
	public ResponseEntity<?> addFlight(Flight flight);

	public Iterable<Flight> viewAllFlight();

	public ResponseEntity<?> viewFlight(BigInteger flightNo);

	public ResponseEntity<?> modifyFlight(Flight flight);

	public ResponseEntity<?> removeFlight(BigInteger flightNo);

}