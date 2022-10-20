package com.cg.fms.exception;

public class ScheduledFlightNotFoundException extends RuntimeException {
	private static final long serialVersionUID=1L;
	
	public ScheduledFlightNotFoundException() {
		
	}
	public ScheduledFlightNotFoundException(String msg) {
		super(msg);
	}

}
