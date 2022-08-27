package com.infy.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infy.Entity.FlightDetails;


public interface FlightRepository extends JpaRepository<FlightDetails,String> {

	@Query("from FlightDetails f where f.destination=:des AND f.source=:s AND f.flightAvailableDate=:d")
	public List<FlightDetails> findFlightDetails( @Param("s") String source,@Param("des") String destination,@Param("d") Date date);
	
	@Query("update FlightDetails f set f.seatCount=:count where f.flightId=:id")
	@Modifying
	public void updateSeatCount(@Param("count") int count,@Param("id") String id);
}
