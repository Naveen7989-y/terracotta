package com.yashu.terracotta.service;

import org.springframework.stereotype.Service;

import com.yashu.terracotta.dto.LoginResponse;
import com.yashu.terracotta.dto.SignupRequest;
import com.yashu.terracotta.entity.User;
import com.yashu.terracotta.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public User signup(SignupRequest request) {
		User user=new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhone(request.getPhone());
		
		return userRepository.save(user);
	}
	public LoginResponse login(String email, String password) {

	    User user = userRepository.findByEmail(email);

	    if (user == null) {
	        throw new RuntimeException("User not found");
	    }

	    if (!user.getPassword().equals(password)) {
	        throw new RuntimeException("Invalid password");
	    }

	    return new LoginResponse(
	    		user.getId(),
	    		user.getName(),
	    		user.getEmail()
	    	);
	}
 

}