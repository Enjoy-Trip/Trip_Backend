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
		return planMapper.planAdd(planDto);
	}

	@Override
	public int planModify(PlanDto planDto) {
		return planMapper.planModify(planDto);
	}

	@Override
	public int planDelete(PlanDto planDto) {
		return planMapper.planDelete(planDto);
	}

	@Override
	public PlanDto planDetail(int planNo) {
		return planMapper.planDetail(planNo);
	}

}
