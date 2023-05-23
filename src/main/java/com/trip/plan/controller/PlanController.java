package com.trip.plan.controller;

import java.util.List;

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
import com.trip.plan.PlanService.PlanService;
import com.trip.plan.model.PlanDto;
import com.trip.response.model.ResponseDto;
import com.trip.user.model.UserDto;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping(value = "/plan")
public class PlanController {
	private final String TOKEN = "Access-Token";
	private PlanService planService;
	private JwtService jwtService;

	public PlanController(PlanService planService, JwtService jwtService) {
		super();
		this.planService = planService;
		this.jwtService = jwtService;
	}

	// 나의 계획 리스트 뿌려주기
	@GetMapping("")
	ResponseEntity<?> planList(HttpServletRequest request) {
		ResponseDto<List<PlanDto>> response = new ResponseDto<List<PlanDto>>();
		String token = request.getHeader(TOKEN);
		try {
			if (token != null) {
				int userNo = jwtService.getData(token, "userNo");
				List<PlanDto> planList = planService.planList(userNo);
				response.setState("SUCCESS");
				response.setMessage("계획들을 불러옵니다.");
				response.setData(planList);
			}
			return new ResponseEntity<ResponseDto<List<PlanDto>>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("계획 불러오기에 실패하였습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	// 계획 디테일 뿌려주기
	@GetMapping("/{planNo}")
	ResponseEntity<?> planDetail(@PathVariable("planNo") int planNo, HttpServletRequest request) {
		ResponseDto<PlanDto> response = new ResponseDto<PlanDto>();
		try {
			PlanDto planDto = planService.planDetail(planNo);
			if (planDto == null) {
				response.setState("FAIL");
				response.setMessage("해당 계획이 존재하지 않습니다.");
			} 
			else {
				String token = request.getHeader(TOKEN);
				if (token != null) {
					int userNo = jwtService.getData(token, "userNo");
					if (planDto.getPlanUser().getUserNo() == userNo) {
						planDto.setPlanLoginCheck(true);
					}
				}
				response.setState("SUCCESS");
				response.setMessage("계획 상세보기를 실행합니다.");
				response.setData(planDto);
			}

			return new ResponseEntity<ResponseDto<PlanDto>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("계획 상세보기에 실패하였습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	// 계획 추가
	@PostMapping("")
	ResponseEntity<?> planAdd(@RequestBody PlanDto planDto, HttpServletRequest request) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		String token = request.getHeader(TOKEN);

		try {
			if (planDto.getPlanUser() == null) {
				planDto.setPlanUser(new UserDto());
			}

			planDto.getPlanUser().setUserNo(jwtService.getData(token, "userNo"));

			int rst = planService.planAdd(planDto);

			response.setState("SUCCESS");
			response.setMessage("등록에 성공 하였습니다.");
			response.setData(rst);

			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {

			response.setState("FAIL");
			response.setMessage("계획 추가에 실패하였습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	// 계획 수정
	@PutMapping("/{planno}")
	ResponseEntity<?> planModify(@PathVariable("planno") int planNo, @RequestBody PlanDto planDto,
			HttpServletRequest request) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		String token = request.getHeader(TOKEN);

		try {
			PlanDto plan = planService.planDetail(planNo);

			if (plan == null) {
				response.setState("FAIL");
				response.setMessage("해당 계획이 존재하지 않습니다.");
			} else {
				int userNo = jwtService.getData(token, "userNo");

				if (userNo != plan.getPlanUser().getUserNo()) {
					response.setState("FAIL");
					response.setMessage("다른 사람의 계획은 수정할 수 없습니다.");
				} else {
					if (planDto.getPlanUser() == null) {
						planDto.setPlanUser(new UserDto());
					}

					planDto.getPlanUser().setUserNo(jwtService.getData(token, "userNo"));
					planDto.setPlanNo(planNo);

					int rst = planService.planModify(planDto);

					response.setState("SUCCESS");
					response.setMessage("수정에 성공 하였습니다.");
					response.setData(rst);
				}
			}

			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("계획 수정에 실패하였습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	// 계획 삭제
	@DeleteMapping("/{planno}")
	ResponseEntity<?> planDelete(@PathVariable("planno") int planNo, HttpServletRequest request) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		String token = request.getHeader(TOKEN);

		try {
			PlanDto plan = planService.planDetail(planNo);

			if (plan == null) {
				response.setState("FAIL");
				response.setMessage("해당 계획이 존재하지 않습니다.");
			} else {
				int userNo = jwtService.getData(token, "userNo");

				if (userNo != plan.getPlanUser().getUserNo()) {
					response.setState("FAIL");
					response.setMessage("다른 사람의 계획은 삭제할 수 없습니다.");
				} else {
					int rst = planService.planDelete(planNo);

					response.setState("SUCCESS");
					response.setMessage("삭제에 성공 하였습니다.");
					response.setData(rst);
				}
			}

			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("계획 삭제에 실패하였습니다.");

			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
}
