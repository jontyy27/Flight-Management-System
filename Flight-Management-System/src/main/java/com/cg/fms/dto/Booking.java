package com.cg.fms.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cg.fms.secure.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Booking {
	@Id
	private BigInteger bookingId;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "User_Id")
	private User userId;
	
	private LocalDate bookingDate;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Passenger.class)
	@JoinColumn(name = "pnrNumber")
	private List<Passenger> passenger;
	private double ticketCost;
	
	@OneToOne
	@JoinColumn(name = "Flight_No")
	private Flight flight;
	
	private Integer noOfPassengers;
	
	
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingid(BigInteger bookingId) {
		this.bookingId = bookingId;
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
