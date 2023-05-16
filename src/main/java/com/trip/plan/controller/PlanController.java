package com.trip.plan.controller;

import java.util.List;

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

import com.trip.plan.PlanService.PlanService;
import com.trip.plan.model.PlanDto;
import com.trip.response.model.ResponseDto;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping(value = "/plan")
public class PlanController {

	private PlanService planService;

	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}

	// 계획 리스트 뿌려주기
	@GetMapping("/{userno}")
	ResponseEntity<?> planList(@PathVariable("userno") int userNo) {
		ResponseDto<List<PlanDto>> response = new ResponseDto<List<PlanDto>>();
		
		try {
			List<PlanDto> planList = planService.planList(userNo);
			
			response.setState("SUCCESS");
			response.setMessage("계획들을 불러옵니다.");
			response.setData(planList);
			
			return new ResponseEntity<ResponseDto<List<PlanDto>>>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	// 계획 추가
	@PostMapping("/{userno}")
	ResponseEntity<?> planAdd(@PathVariable("userno") int userNo, @RequestBody PlanDto planDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = planService.planAdd(planDto);

			response.setState("SUCCESS");
			response.setMessage("등록에 성공 하였습니다.");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	// 계획 수정
	@PutMapping("/{planno}")
	ResponseEntity<?> planModify(@PathVariable("planno") int planNo, @RequestBody PlanDto planDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		try {
			planDto.setPlanNo(planNo);
			int rst = planService.planModify(planDto);

			response.setState("SUCCESS");
			response.setMessage("수정에 성공 하였습니다.");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}

	// 계획 삭제
	@DeleteMapping("/{planno}")
	ResponseEntity<?> planDelete(@PathVariable("planno") int planNo) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		try {
			int rst = planService.planDelete(planNo);

			response.setState("SUCCESS");
			response.setMessage("삭제에 성공 하였습니다.");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
}
