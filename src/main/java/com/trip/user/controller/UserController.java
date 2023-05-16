package com.trip.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.response.model.ResponseDto;
import com.trip.user.model.UserDto;
import com.trip.user.service.UserService;

import com.trip.util.ExceptionHandler;

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
		ResponseDto<UserDto> response = new ResponseDto<UserDto>();
		
		try {
			UserDto loginUser = userService.login(user);
			
			if (loginUser == null) {
				response.setState("FAIL");
				response.setMessage("아이디 혹은 비밀번호가 일치하지 않습니다.");
			} else {
				response.setState("SUCCESS");
				response.setMessage("정상적으로 로그인이 진행되었습니다.");
				response.setData(loginUser);
			}
			
			return new ResponseEntity<ResponseDto<UserDto>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("로그인 도중 오류가 발생했습니다.");
			
			return new ResponseEntity<ResponseDto<UserDto>>(response, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> signup(@RequestBody UserDto user){
		try {
			return new ResponseEntity<Integer>(userService.signup(user), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@GetMapping(value = "/{userNo}")
	public ResponseEntity<?> info(@PathVariable("userNo") int userNo) {
		try {
			return new ResponseEntity<UserDto>(userService.info(userNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PutMapping(value = "/{userNo}")
	public ResponseEntity<?> modify(@PathVariable("userNo") int userNo, @RequestBody UserDto user) {
		try {
			user.setUserNo(userNo);
			return new ResponseEntity<Integer>(userService.modify(user), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@DeleteMapping(value = "/{userNo}")
	public ResponseEntity<?> delete(@PathVariable("userNo") int userNo) {
		try {
			return new ResponseEntity<Integer>(userService.delete(userNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
