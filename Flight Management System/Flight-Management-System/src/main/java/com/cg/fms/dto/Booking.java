package com.cg.fms.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	private BigInteger bookingid;
	private User userId;
	private LocalDate bookingDate;
	private List<Passenger> passenger;
	private double ticketCost;
	private Flight flight;
	private Integer noOfPassengers;
	public BigInteger getBookingid() {
		return bookingid;
	}
	public void setBookingid(BigInteger bookingid) {
		this.bookingid = bookingid;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	

}
