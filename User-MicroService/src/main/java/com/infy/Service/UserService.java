package com.infy.Service;


import com.infy.Dto.UserDetailsDTO;
public interface UserService {
	public void userRegister(UserDetailsDTO user);
	public String userLogin(UserDetailsDTO user);
	public UserDetailsDTO checkUser(String userId);
}
