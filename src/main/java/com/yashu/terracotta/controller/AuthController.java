package com.yashu.terracotta.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashu.terracotta.dto.LoginRequest;
import com.yashu.terracotta.dto.LoginResponse;
import com.yashu.terracotta.dto.SignupRequest;
import com.yashu.terracotta.entity.User;
import com.yashu.terracotta.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private UserService userService;
	
	public AuthController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/signup")
	public User signup(@Valid @RequestBody SignupRequest request) {
		
		return userService.signup(request);
	}
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {

	    return userService.login(
	            request.getEmail(),
	            request.getPassword()
	    );
	}
}
