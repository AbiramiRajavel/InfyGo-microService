package com.infy.Service;


import java.util.Set;

import com.infy.Dto.CreditcardDetailsDTO;
import com.infy.Dto.FlightDetailsDTO;
import com.infy.Dto.PassengerDetailsDTO;
import com.infy.Dto.UserDetailsDTO;

public interface BookingService {
    public String bookTickets(FlightDetailsDTO flightDto,UserDetailsDTO userDto,Set<PassengerDetailsDTO> passengerDetails);
    public String payment(CreditcardDetailsDTO creditCardDto);
}
