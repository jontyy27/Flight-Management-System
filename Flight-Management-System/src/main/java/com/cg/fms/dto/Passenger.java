package com.cg.fms.dto;

import java.math.BigInteger;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

public class Passenger {
	@Id
	private int pnrNumber;
	private String pasengerName;
	private Integer passengerAge;
	private BigInteger passengerUIN;
	private Double luggage;

	public Passenger() {
		super();
	}
	
    @JsonCreator
	public Passenger(@JsonProperty("pnrNumber")int pnrNumber,@JsonProperty("pasengerName")String pasengerName,@JsonProperty("passengerAge")Integer passengerAge,@JsonProperty("passengerUIN")BigInteger passengerUIN,
			@JsonProperty("luggage")Double luggage) {
		super();
		this.pnrNumber = pnrNumber;
		this.pasengerName = pasengerName;
		this.passengerAge = passengerAge;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}

	public int getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPasengerName() {
		return pasengerName;
	}
	public void setPasengerName(String pasengerName) {
		this.pasengerName = pasengerName;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Double getLuggage() {
		return luggage;
	}
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}
}
