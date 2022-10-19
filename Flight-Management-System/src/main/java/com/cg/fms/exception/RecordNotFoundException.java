package com.cg.fms.exception;

public class RecordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String msg) {
		super(msg);
	}

}
