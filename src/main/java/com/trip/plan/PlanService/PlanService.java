package com.trip.plan.PlanService;

import java.util.List;

import com.trip.plan.model.PlanDto;

public interface PlanService {

	//리스트 전체 뿌려주기
	List<PlanDto> planList(int userNo);
	
	//계획 추가
	int planAdd(PlanDto planDto);
	
	//계획 수정
	int planModify(PlanDto planDto);
	
	//계획 삭제
	int planDelete(PlanDto planDto);

	//리스트 눌렀을때 detail 뿌리기
	PlanDto planDetail(int planNo);

	Integer planDelete(int planNo);
	
}
