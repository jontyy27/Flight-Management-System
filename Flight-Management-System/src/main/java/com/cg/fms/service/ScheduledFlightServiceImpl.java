package com.cg.fms.service;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.fms.dto.Schedule;
import com.cg.fms.repository.ScheduleDao;
import com.cg.fms.repository.ScheduledFlightDao;
import com.cg.fms.secure.model.User;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.exception.ScheduledFlightNotFoundException;
import com.cg.fms.dto.ScheduledFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	
	 //Creating DAO object
	
	@Autowired
	ScheduledFlightDao dao;

	@Autowired
	ScheduleDao scheduleDao;

	@Autowired
	BookingService bookingService;

	
	 // Service method to add new Scheduled flight to database
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> addScheduledFlight(ScheduledFlight scheduledFlight) {
		Optional<ScheduledFlight> findSFById = dao.findById(scheduledFlight.getScheduleFlightId());
		try {
			if(findSFById.isPresent()) {
				throw new RecordAlreadyPresentException("Schedule Flight with Id: "+ scheduledFlight.getScheduleFlightId() +" already exists!!");
				}
			else {
				dao.save(scheduledFlight);
				return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.OK);
			}
			}catch(RecordAlreadyPresentException e) {
				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		
	}
	// Service method to modify existing Scheduled flight in database

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public ResponseEntity<?> updateScheduledFlight(ScheduledFlight updatedSF) {
			Optional<ScheduledFlight> findSFId = dao.findById(updatedSF.getScheduleFlightId());
			try {
				
				if(findSFId.isPresent()) {
					ScheduledFlight updatedScheduleFlight = dao.findById(updatedSF.getScheduleFlightId()).get();
					Schedule updateSchedule = scheduleDao.findById(updatedSF.getSchedule().getScheduleId()).get();
					updatedScheduleFlight.setAvailableSeats(updatedSF.getAvailableSeats());
					updateSchedule.setSrcAirport(updatedSF.getSchedule().getSrcAirport());
					updateSchedule.setDstnAirport(updatedSF.getSchedule().getDstnAirport());
					updateSchedule.setArrDateTime(updatedSF.getSchedule().getArrDateTime());
					updateSchedule.setDeptDateTime(updatedSF.getSchedule().getDeptDateTime());
					dao.save(updatedSF);
					return new ResponseEntity(updatedSF, HttpStatus.OK);

				}
				
				else
					throw new RecordNotFoundException("Flight Schedule with id: "+ updatedSF.getScheduleFlightId() + " does not exists!!");
			}catch(RecordNotFoundException e) {
				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			}

		
		}
			
	/*
	 // Service method to modify existing Scheduled flight in database
	 
	@Override
	public ResponseEntity<?> modifySF(ScheduledFlight scheduleFlight) {
		Optional<ScheduledFlight> findSFId = dao.findById(scheduleFlight.getScheduleFlightId());
		try {
			if(findSFById.isPresent()) {
		
		ScheduledFlight updateScheduleFlight = dao.findById(scheduleFlight.getScheduleFlightId()).get();
		Schedule updateSchedule = scheduleDao.findById(scheduleFlight.getSchedule().getScheduleId()).get();
		updateScheduleFlight.setAvailableSeats(scheduleFlight.getAvailableSeats());
		updateSchedule.setSrcAirport(scheduleFlight.getSchedule().getSrcAirport());
		updateSchedule.setDstnAirport(scheduleFlight.getSchedule().getDstnAirport());
		updateSchedule.setArrDateTime(scheduleFlight.getSchedule().getArrDateTime());
		updateSchedule.setDeptDateTime(scheduleFlight.getSchedule().getDeptDateTime());
		dao.save(updateScheduleFlight);
		return scheduleFlight;
	}

	*/
	 // Service method to remove existing Scheduled flight from database
	 
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public ResponseEntity<?> removeScheduledFlight(BigInteger flightId) {
			if (flightId == null)
				throw new RecordNotFoundException("Enter flight Id");
		
			Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
			try {
			if (!scheduleFlight.isPresent())
				throw new RecordNotFoundException("Enter a valid Scheduled Flight Id");
			else {
				// try {
				// cancelBookings(flightId);
				// } catch (RecordNotFoundException e) {
				// System.out.println("No Bookings Found");
				// }
				ScheduledFlight deleteId= scheduleFlight.get();
				dao.deleteById(flightId);
				return new ResponseEntity<ScheduledFlight>(deleteId, HttpStatus.OK);		

			}
			}catch(RecordNotFoundException e) {
				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			}			

		}
	
	 // Service method to view all Scheduled flights in database
	 
	@Override
	public Iterable<ScheduledFlight> viewAllScheduledFlights() {
		return dao.findAll();
	}

	
	 // Service method to view a Scheduled flight by ID from database
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> viewScheduledFlight(BigInteger flightId){
		if (flightId == null)
			throw new ScheduledFlightNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
		try{
			if (!scheduleFlight.isPresent()){
			throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
			}
		else {
			
		}
			ScheduledFlight SFId= scheduleFlight.get();
			return new ResponseEntity<ScheduledFlight>(SFId, HttpStatus.OK);

			}catch(RecordNotFoundException e) {
				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
			}
	}
		

	

}