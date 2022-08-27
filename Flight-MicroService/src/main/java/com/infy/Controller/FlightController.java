package com.infy.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.Dto.FlightDetailsDTO;
import com.infy.Service.FlightService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/flights")
public class FlightController
{
	@Autowired
	private FlightService flightService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> register(@RequestBody FlightDetailsDTO flightDetailsdto)
	{
		flightService.add(flightDetailsdto);
	     return new ResponseEntity<String>("Added Successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sources")
	@CircuitBreaker(name="service",fallbackMethod="fallMethod")
	public ResponseEntity<String> flightSources()
	{
		String sources=flightService.getSource();
	   return new ResponseEntity<String>(sources,HttpStatus.OK);
	}
	@GetMapping("/destinations")
	@CircuitBreaker(name="service",fallbackMethod="fallMethod")
	public ResponseEntity<String> flightDestination()
	{
		String destinations=flightService.getDestination();
		return new ResponseEntity<String>(destinations,HttpStatus.OK);
	}
	@GetMapping("/{source}/{destination}/{date}")
	@CircuitBreaker(name="service",fallbackMethod="fallMethod")
	public ResponseEntity<List<FlightDetailsDTO>> flightDetailsBasedOn(@PathVariable String source,@PathVariable String destination,@PathVariable String date) 
	{
		List<FlightDetailsDTO> details=flightService.flightDetails( source,destination,date);
		return new ResponseEntity<List<FlightDetailsDTO>>(details,HttpStatus.OK);
	}
	
	@GetMapping("/{flightId}")
	@CircuitBreaker(name="service",fallbackMethod="fallMethod")
	public FlightDetailsDTO checkFlightId(@PathVariable String flightId)
	{
		FlightDetailsDTO flight=flightService.checkFlightId(flightId);
		return flight;
     }
	@GetMapping("/seat/{currentSeatCount}/{flightId}")
	@CircuitBreaker(name="service",fallbackMethod="fallMethod")
	public String updateSeatCount(@PathVariable int currentSeatCount, @PathVariable String flightId) {
		flightService.updateSeatCount(currentSeatCount,flightId);
		return "Seat count updated";
	}
	
	 public  ResponseEntity<String> fallMethod(Throwable throwable){
	    	return new ResponseEntity<String>("Unexpected error occured ",HttpStatus.OK);    
	    }
	 public  ResponseEntity<List<FlightDetailsDTO>> fallMethod(String source, String destination, String date,Exception e){
	    	return null;    
	    }
	 
	 public  FlightDetailsDTO fallMethod(String flightId,Throwable throwable){
	    	return null;   
	    }
	 public  String fallMethod(int currentSeatCount, String flightId,Throwable throwable){
	    	return "Unexpected error occured in seat update";   
	    }


}