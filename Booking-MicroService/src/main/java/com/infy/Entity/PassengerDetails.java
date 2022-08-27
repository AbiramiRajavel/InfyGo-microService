package com.infy.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PassengerDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer passengerId;
	private String passenagerAge;
	private String passengerGender;
	private String passengerName;
    private Integer ticketPnr;
    
	public PassengerDetails() {
		super();
	}
	
	public PassengerDetails(Integer passengerId, String passenagerAge, String passengerGender, String passengerName,
			Integer ticketPnr) {
		super();
		this.passengerId = passengerId;
		this.passenagerAge = passenagerAge;
		this.passengerGender = passengerGender;
		this.passengerName = passengerName;
		this.ticketPnr = ticketPnr;
	}

	public Integer getTicketPnr() {
		return ticketPnr;
	}

	public void setTicketPnr(Integer ticketPnr) {
		this.ticketPnr = ticketPnr;
	}

	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassenagerAge() {
		return passenagerAge;
	}
	public void setPassenagerAge(String passenagerAge) {
		this.passenagerAge = passenagerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	
	
	

}
