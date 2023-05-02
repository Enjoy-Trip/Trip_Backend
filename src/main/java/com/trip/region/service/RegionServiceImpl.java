package com.trip.region.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.region.mapper.RegionMapper;
import com.trip.region.model.RegionDto;

@Service
public class RegionServiceImpl implements RegionService {
	private RegionMapper regionMapper;
	
	public RegionServiceImpl(RegionMapper regionMapper) {
		super();
		this.regionMapper = regionMapper;
	}

	@Override
	public List<RegionDto> sidoList() {
		return regionMapper.sidoList();
	}

	@Override
	public List<RegionDto> gugunList(int sidoCode) {
		return regionMapper.gugunList(sidoCode);
	}
}
