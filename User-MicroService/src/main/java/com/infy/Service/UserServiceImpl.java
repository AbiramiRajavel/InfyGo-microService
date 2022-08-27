package com.infy.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infy.Dto.UserDetailsDTO;

import com.infy.Entity.UserDetails;
import com.infy.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
    ModelMapper mapper;
	
	@Override
	public void userRegister(UserDetailsDTO userdto) {
		UserDetails user=mapper.map(userdto, UserDetails.class);
		userRepo.save(user);
	}

	@Override
	public String userLogin(UserDetailsDTO userdto) {
		UserDetails user=mapper.map(userdto, UserDetails.class);
		Optional<UserDetails> op=userRepo.findById(user.getUserId());
		if(op.isPresent()) {
			return  "Successfully Logged in";
		}
		return "User Not Found";
	}

	@Override
	public UserDetailsDTO checkUser(String userId) {
		    Optional<UserDetails> user=userRepo.findById(userId);
		    UserDetailsDTO userDto=null;
		    if(user.isPresent()) {
		    	UserDetails user1=user.get();
		    	userDto=mapper.map(user1, UserDetailsDTO.class);
		    }
			return userDto;
		
	}
	

}
