package com.infy.Service;

import java.util.List;
import com.infy.Dto.FlightDetailsDTO;

public interface FlightService 
{
	public void add(FlightDetailsDTO flightDetailsdto);
	public String getSource();
	public String getDestination();
    public List<FlightDetailsDTO> flightDetails(String destination,String source,String date);
    public FlightDetailsDTO checkFlightId(String flightId);
    public void updateSeatCount(int count, String flightId);
}
