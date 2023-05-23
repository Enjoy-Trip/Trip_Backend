package com.trip.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

import com.trip.jwt.JwtService;
import com.trip.response.model.ResponseDto;
import com.trip.user.model.UserDto;
import com.trip.user.service.UserService;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping("/user")
public class UserController {
	private final String TOKEN = "Access-Token";
	private UserService userService;
	private JwtService jwtService;

	public UserController(UserService userService, JwtService jwtService) {
		super();
		this.userService = userService;
		this.jwtService = jwtService;
	}
	
	@PostMapping(value = "/refresh")
	public ResponseEntity<?> login(@RequestBody HashMap<String, String> map) {
		ResponseDto<String> response = new ResponseDto<String>();
		String refreshToken = map.get("refreshToken");
		
		try {
			int userNo = userService.refresh(refreshToken);
			
			String AccessToken = jwtService.createAccessToken("userNo", userNo);
			
			response.setState("SUCCESS");
			response.setMessage("정상적으로 로그인이 진행되었습니다.");
			response.setData(AccessToken);

			return new ResponseEntity<ResponseDto<String>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("로그인 도중 오류가 발생했습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserDto user) {
		ResponseDto<HashMap<String, String>> response = new ResponseDto<HashMap<String, String>>();

		try {
			UserDto loginUser = userService.login(user);

			if (loginUser == null) {
				response.setState("FAIL");
				response.setMessage("아이디 혹은 비밀번호가 일치하지 않습니다.");
			} else {
				String accessToken = jwtService.createAccessToken("userNo", loginUser.getUserNo());
				String refreshToken = jwtService.createRefreshToken("userNo", loginUser.getUserNo());
				
				userService.saveRefreshToken(loginUser.getUserNo(), refreshToken);

				HashMap<String, String> map = new HashMap<String, String>();

				map.put("Access-Token", accessToken);
				map.put("Refresh-Token", refreshToken);

				response.setState("SUCCESS");
				response.setMessage("정상적으로 로그인이 진행되었습니다.");
				response.setData(map);
			}

			return new ResponseEntity<ResponseDto<HashMap<String, String>>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("로그인 도중 오류가 발생했습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	@GetMapping(value = "/check/{userid}")
	public ResponseEntity<?> check(@PathVariable("userid") String userId) {
		ResponseDto<String> response = new ResponseDto<String>();

		try {
			String rst = userService.check(userId);

			if (rst == null) {
				response.setState("SUCCESS");
				response.setMessage("중복되는 아이디가 없습니다.");
			} else {
				response.setState("FAIL");
				response.setMessage("중복되는 아이디가 존재합니다.");
				response.setData(rst);
			}

			return new ResponseEntity<ResponseDto<String>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("아이디 체크 도중 오류가 발생했습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<?> signup(@RequestBody UserDto user) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
<<<<<<< HEAD
		System.out.println(user.toString());
=======
		
>>>>>>> f6ce628bac3934d073d4eab3338a7b7bc62c0cfa
		try {
			int rst = userService.signup(user);

			response.setState("SUCCESS");
			response.setMessage("정상적으로 회원가입이 진행되었습니다.");
			response.setData(rst);

			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("회원가입 도중 오류가 발생했습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	@GetMapping(value = "/{userNo}")
	public ResponseEntity<?> info(@PathVariable("userNo") int userNo) {
		ResponseDto<UserDto> response = new ResponseDto<UserDto>();

		try {
			UserDto user = userService.info(userNo);

			if (user == null) {
				response.setState("FAIL");
				response.setMessage("찾으시는 사용자가 존재하지 않습니다.");
			} else {
				response.setState("SUCCESS");
				response.setMessage("찾으시는 사용자가 존재합니다.");
				response.setData(user);
			}

			return new ResponseEntity<ResponseDto<UserDto>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("사용자 검색 도중 오류가 발생했습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	@PutMapping(value = "")
	public ResponseEntity<?> modify(@RequestBody UserDto user, HttpServletRequest request) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		String token = request.getHeader(TOKEN);
		
		try {
			int userNo = jwtService.getData(token, "userNo");

			UserDto modifyUser = userService.info(userNo);

			if (modifyUser == null) {
				response.setState("FAIL");
				response.setMessage("수정하고자 하는 사용자가 존재하지 않습니다.");
			} else {
				user.setUserNo(userNo);

				int rst = userService.modify(user);

				response.setState("SUCCESS");
				response.setMessage("정상적으로 회원 정보 수정이 진행되었습니다.");
				response.setData(rst);
			}

			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("회원 정보 수정 도중 오류가 발생했습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	@DeleteMapping(value = "")
	public ResponseEntity<?> delete(HttpServletRequest request) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		String token = request.getHeader(TOKEN);
		
		try {
			int userNo = jwtService.getData(token, "userNo");

			UserDto modifyUser = userService.info(userNo);

			if (modifyUser == null) {
				response.setState("FAIL");
				response.setMessage("삭제하고자 하는 사용자가 존재하지 않습니다.");
			} else {
				int rst = userService.delete(userNo);

				response.setState("SUCCESS");
				response.setMessage("정상적으로 회원 정보 삭제가 완료되었습니다.");
				response.setData(rst);
			}

			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("회원 정보 삭제 도중 오류가 발생했습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
}
