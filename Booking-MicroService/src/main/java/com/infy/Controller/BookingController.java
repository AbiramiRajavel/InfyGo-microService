package com.infy.Controller;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.Dto.CreditcardDetailsDTO;
import com.infy.Dto.FlightDetailsDTO;
import com.infy.Dto.PassengerDetailsDTO;
import com.infy.Dto.UserDetailsDTO;
import com.infy.Service.BookingService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@Autowired
    DiscoveryClient client;
	@Autowired
	private RestTemplate temp;

	
    @PostMapping("{FlightId}/{UserId}")
	@CircuitBreaker(name="service",fallbackMethod="fallMethod")
    public ResponseEntity<String> bookingTicket(@PathVariable("FlightId")String flightId,@PathVariable("UserId") String userId,@RequestBody Set<PassengerDetailsDTO> passengerDetails)
    {
    	FlightDetailsDTO flightDto=temp.getForObject("http://FlightMS/flights/"+flightId,  FlightDetailsDTO.class);
        UserDetailsDTO userDto=temp.getForObject("http://UserMS/userId/"+userId, UserDetailsDTO.class);
    	String result= bookingService.bookTickets(flightDto, userDto, passengerDetails);
    	return new ResponseEntity<String>(result,HttpStatus.OK);
    }
    
    @PostMapping("/payment")
    @CircuitBreaker(name="service",fallbackMethod="fallMethod")
    public ResponseEntity<String> payment(@Valid @RequestBody CreditcardDetailsDTO creditCardDto){
    	return new ResponseEntity<String>(bookingService.payment(creditCardDto),HttpStatus.ACCEPTED);
    }
    
    public  ResponseEntity<String> fallMethod(String flightId, String userId,  Set<PassengerDetailsDTO> passengerDetails,Throwable throwable){
    	return new ResponseEntity<String>("Unexpected error occured in flight Booking",HttpStatus.OK);
    
    }
    public  ResponseEntity<String> fallMethod(CreditcardDetailsDTO creditCardDto,Throwable throwable){
    	return new ResponseEntity<String>("Unexpected error occured in payment",HttpStatus.OK);
    
    }
  
}
