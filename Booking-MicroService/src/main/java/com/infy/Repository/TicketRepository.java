package com.infy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.TicketDetails;

public interface TicketRepository extends JpaRepository<TicketDetails,Integer> {

}
