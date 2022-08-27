package com.infy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.infy.Entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails,String>{

}
