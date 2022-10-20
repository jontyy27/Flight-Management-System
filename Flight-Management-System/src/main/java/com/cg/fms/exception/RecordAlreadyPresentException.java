package com.cg.fms.exception;

public class RecordAlreadyPresentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecordAlreadyPresentException() {
		
	}
	public RecordAlreadyPresentException(String msg) {
		super(msg);
	}

}
