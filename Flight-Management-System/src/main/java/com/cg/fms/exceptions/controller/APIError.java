package com.cg.fms.exceptions.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class APIError {

	private String msg;
	private int error;

	public APIError() {
		// TODO Auto-generated constructor stub
	}

	public APIError(String msg, int error) {
		super();
		this.msg = msg;
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

}
