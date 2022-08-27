 package com.infy.Service;

import java.sql.Date;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.Dto.CreditcardDetailsDTO;
import com.infy.Dto.FlightDetailsDTO;
import com.infy.Dto.PassengerDetailsDTO;
import com.infy.Dto.UserDetailsDTO;
import com.infy.Entity.CreditcardDetails;
import com.infy.Entity.PassengerDetails;
import com.infy.Entity.TicketDetails;
import com.infy.Repository.CerditCardRepository;
import com.infy.Repository.PassengerRepository;
import com.infy.Repository.TicketRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	PassengerRepository passengerRepo;
	@Autowired
	CerditCardRepository creditcardRepo;
	@Autowired
	ModelMapper mapper;
	@Autowired
	private RestTemplate temp;
	
	@Override
	public String bookTickets(FlightDetailsDTO flightDto,UserDetailsDTO userDto,Set<PassengerDetailsDTO> passengerDetails) {

		if(flightDto!=null&&userDto!=null)
		{
			 
			 System.out.println("insode up");
		    int currentSeatCount=flightDto.getSeatCount();
		    int passengerCount=passengerDetails.size();
		    if(currentSeatCount>=passengerCount) 
		    {
		    
		      TicketDetails ticketDetails=new TicketDetails();
		      int ranId=(int)Math.floor(Math.random()*10000+9*10-2);
		      ticketDetails.setPnr(ranId);
		      Date bDate=Date.valueOf(LocalDate.now());
		      ticketDetails.setBookingDate(bDate);
		      Date date=Date.valueOf(LocalDate.now().plusDays(2));
		      ticketDetails.setDepartureDate(date);
		      ticketDetails.setDepartureTime("2pm");
		      ticketDetails.setFlightId(flightDto.getFlightId());
		      ticketDetails.setNoOfSeats(passengerDetails.size());
		      double totalFare=flightDto.getFare()*passengerDetails.size();
		      ticketDetails.setTotalFare(totalFare);
		      ticketDetails.setUserId(userDto.getUserId());
		      ticketRepository.save(ticketDetails);
		      addPassenger(ranId,passengerDetails);
		      
		      int updateSeatCount=currentSeatCount-passengerCount;
		     String updated= temp.getForObject("http://FlightMS/flights/seat/"+updateSeatCount+"/"+flightDto.getFlightId(), String.class);
		    }
		    else 
		    {
		    	return "Sorry seat is full!";
		    }
		}
		else
		{
			return "Wrong FlightId/userId";
		}
		return "Ticket booked successfully";
		
	}
	public void addPassenger(Integer ticketPnr,Set<PassengerDetailsDTO> passengerDetailsdto) {
		Set<PassengerDetails> passenger=new HashSet<>();
		for(PassengerDetailsDTO passengerEn:passengerDetailsdto) {
			PassengerDetails pass=passengerEn.mapDto(passengerEn);
			pass.setTicketPnr(ticketPnr);
			passenger.add(pass);
		}
		passengerRepo.saveAllAndFlush(passenger);
	}
	
	@Override
	public String payment(CreditcardDetailsDTO creditCardDto) {
		CreditcardDetails creditCard=mapper.map(creditCardDto, CreditcardDetails.class);
		int year=Integer.parseInt(creditCard.getExpiryYear());
		
		if(year>LocalDate.now().getYear())
		{
		creditcardRepo.save(creditCard);
		return "Payment Successful";
		}
		else {
			return "Expiry year must be Greater than the current year";
		}
	}

	

}
