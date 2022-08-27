package com.infy.Dto;

import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightDetailsDTO {
	private String flightId;
	private String airLine;
	private String arrivalTime;
	private String departureTime;
	private String destination;
	private Double fare;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date flightAvailableDate;
	private Integer seatCount;
	private String source;
	
	public FlightDetailsDTO() {
		super();
	}
	public FlightDetailsDTO( String flightId,String airLine, String arrivalTime, String departureTime,
			String destination, Double fare, Date flightAvailableDate, Integer seatCount, String source) {
		super();
		this.flightId = flightId;
		this.airLine = airLine;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.destination = destination;
		this.fare = fare;
		this.flightAvailableDate = flightAvailableDate;
		this.seatCount = seatCount;
		this.source = source;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getAirLine() {
		return airLine;
	}
	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public Date getFlightAvailableDate() {
		return flightAvailableDate;
	}
	public void setFlightAvailableDate(Date flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}
	public Integer getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
}
