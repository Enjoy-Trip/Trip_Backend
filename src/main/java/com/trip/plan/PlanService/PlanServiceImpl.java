package com.trip.plan.PlanService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.plan.mapper.PlanMapper;
import com.trip.plan.model.PlanDto;

@Service
public class PlanServiceImpl implements PlanService {

	private PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}

	@Override
	public List<PlanDto> planList(int userNo) {
		return planMapper.planList(userNo);
	}

	@Override
	public int planAdd(PlanDto planDto) {
		planMapper.planAdd(planDto);
		return planMapper.planDetailAdd(planDto);
	}
	
	@Override
	public int planDelete(int planNo) {
		return planMapper.planDelete(planNo);
	}
	
	@Override
	public int planModify(PlanDto planDto) {
		return planMapper.planModify(planDto);
	}

	@Override
	public PlanDto planDetail(int planNo) {
		return planMapper.planDetail(planNo);
	}

}
