package com.cg.fms.service;


import java.math.BigInteger;

import com.cg.fms.dto.Flight;

public interface FlightService {
	public Flight addFlight(Flight flight);

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(BigInteger flightNumber);

	public Flight modifyFlight(Flight flight);

	public String removeFlight(BigInteger flightNumber);

}