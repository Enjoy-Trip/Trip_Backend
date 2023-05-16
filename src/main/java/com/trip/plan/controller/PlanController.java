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
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping(value = "/plan")
public class PlanController {

	private PlanService planService;

	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}
	
	//계획 리스트 뿌려주기
	@GetMapping("/{userno}")
	ResponseEntity<?> planList(@PathVariable("userno") int userNo){
		try {
			return new ResponseEntity<List<PlanDto>>(planService.planList(userNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	//계획 추가
	@PostMapping("/{userno}")
	ResponseEntity<?> planAdd(@PathVariable("userno") int userNo, @RequestBody PlanDto planDto){
		try {
			planDto.setUserNo(userNo);
			return new ResponseEntity<Integer>(planService.planAdd(planDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	//계획 삭제
	@DeleteMapping("/{planno}")
	ResponseEntity<?> planDelete(@PathVariable("planno") int planNo){
		try {
			return new ResponseEntity<Integer>(planService.planDelete(planNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	//계획 수정
	@PutMapping("/{planno}")
	ResponseEntity<?> planModify(@PathVariable("planno") int planNo, @RequestBody PlanDto planDto){
		try {
			planDto.setPlanNo(planNo);
			System.out.println(planDto);
			return new ResponseEntity<Integer>(planService.planModify(planDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
