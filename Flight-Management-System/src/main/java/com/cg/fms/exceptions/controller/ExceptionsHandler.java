package com.cg.fms.exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fms.exception.RecordAlreadyPresentException;
import com.cg.fms.exception.RecordNotFoundException;
import com.cg.fms.exception.ScheduledFlightNotFoundException;

@RestControllerAdvice // acts as a catch block

public class ExceptionsHandler {
	
	/*Record Already Present Exception Handler*/
	@ExceptionHandler(value=RecordAlreadyPresentException.class)
	public ResponseEntity<APIError> RecordAlreadyPresentExceptionHandler(Exception e){
		APIError error = new APIError("Record already present in database",404);
		
		return new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	}
	
    /*Record Not Found Exception Handler*/
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<APIError> RecordNotFoundExceptionHandler(Exception e) {
		System.out.println("Inside Exception handler");
		APIError error= new APIError("Record not found in the database",404);
		
		return new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	}
	
	/*Scheduled Flight Not Found Exception*/
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<APIError> ScheduledFlightNotFoundExceptionHandler(Exception e) {
		APIError error= new APIError("Scheduled flight not found in database",404);
	
		return new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	}
}
