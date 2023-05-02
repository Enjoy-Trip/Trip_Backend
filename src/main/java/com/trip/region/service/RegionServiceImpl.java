package com.trip.region.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.region.mapper.RegionMapper;
import com.trip.region.model.SidoDto;

@Service
public class RegionServiceImpl implements RegionService {
	private RegionMapper regionMapper;
	
	public RegionServiceImpl(RegionMapper regionMapper) {
		super();
		this.regionMapper = regionMapper;
	}

	@Override
	public List<SidoDto> sidoList() {
		return regionMapper.sidoList();
	}

	@Override
	public List<SidoDto> sidoDetail(int sidoCode) {
		return regionMapper.sidoDetail(sidoCode);
	}
}
