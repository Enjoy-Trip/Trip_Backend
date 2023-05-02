package com.trip.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.user.model.UserDto;
import com.trip.user.service.UserService;

@RestController
@RequestMapping("/user")
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
	
	@PutMapping(value = "/modify/{userNo}")
	public ResponseEntity<?> modify(@PathVariable("userNo") int userNo, @RequestBody UserDto user) {
		try {
			user.setUserNo(userNo);
			return new ResponseEntity<Integer>(userService.modify(user), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping(value = "/delete/{userNo}")
	public ResponseEntity<?> delete(@PathVariable("userNo") int userNo) {
		try {
			return new ResponseEntity<Integer>(userService.delete(userNo), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
