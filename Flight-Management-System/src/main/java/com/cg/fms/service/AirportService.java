package com.cg.fms.service;

import org.springframework.http.ResponseEntity;

import com.cg.fms.dto.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public ResponseEntity<?> viewAirport(String airportName);

	public ResponseEntity<?> addAirport(Airport airport);

	public ResponseEntity<?> modifyAirport(Airport airport);

	public ResponseEntity<?> removeAirport(String airportName);
}

