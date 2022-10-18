package com.cg.fms.service;


import java.math.BigInteger;


import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.exception.ScheduledFlightNotFoundException;
import com.cg.fms.dto.ScheduledFlight;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

	public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;

	public Iterable<ScheduledFlight> viewAllScheduledFlights();

	public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}