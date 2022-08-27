package com.infy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.Entity.PassengerDetails;

public interface PassengerRepository extends JpaRepository<PassengerDetails,Integer>{

}
