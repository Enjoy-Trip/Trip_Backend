package com.trip.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.user.model.UserDto;
import com.trip.user.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserDto user) {
		try {
			return new ResponseEntity<UserDto>(userService.login(user), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> signup(@RequestBody UserDto user){
		try {
			return new ResponseEntity<Integer>(userService.signup(user), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
