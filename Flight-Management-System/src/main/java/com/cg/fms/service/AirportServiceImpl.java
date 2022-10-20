package com.cg.fms.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.fms.dto.Airport;
import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.repository.AirportDao;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportDao airportDao;

	
	 // view all Airports
	 
	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportDao.findAll();
	}

	
	 // view airport by airportCode
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> viewAirport(String airportName) {
		Optional<Airport> findById = airportDao.findById(airportName);
		try {
			if (findById.isPresent()) {
				Airport findAirport = findById.get();
				return new ResponseEntity<Airport>(findAirport, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Airport with airport code: " + airportName + " not exists");
		
			}catch(RecordNotFoundException e) {
				return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}	
	
	 // adding a airport
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<?> addAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getAirportName());
		try {
		   if(findById.isPresent()) {
			   throw new RecordAlreadyPresentException(
						"Airport with code : " + airport.getAirportName() + " already present");
		   }else {
			airportDao.save(airport);
			return new ResponseEntity<Airport>(airport, HttpStatus.OK);
		   } 
		} catch(RecordAlreadyPresentException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	
	 // modifying an Airport
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<?> modifyAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getAirportName());
		try {
			if (findById.isPresent()) {
				airportDao.save(airport);
				return new ResponseEntity<Airport>(airport,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Airport with code: " + airport.getAirportName() + " not exists");
		} catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	
	 // removing an airport
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<?> removeAirport(String airportName) {
		Optional<Airport> findById = airportDao.findById(airportName);
		try {
			if (findById.isPresent()) {
				Airport deleteId = findById.get();
				airportDao.deleteById(airportName);
				return new ResponseEntity<Airport>(deleteId, HttpStatus.OK);
		}
		 else
			throw new RecordNotFoundException("Airport with code: " + airportName + " not exists");
		}catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
