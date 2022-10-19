package com.cg.fms.exceptions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.fms.dto.APIError;
import com.cg.fms.exception.RecordAlreadyPresentException;

// Global exception handler
@RestControllerAdvice
public class RecordAlreadyPresentExceptionHandler {

	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<APIError> handler(Exception e){
		APIError error = new APIError(e.getMessage(),404);
		
		return new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	}
	
}
