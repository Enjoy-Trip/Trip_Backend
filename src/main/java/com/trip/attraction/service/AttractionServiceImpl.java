package com.trip.attraction.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trip.attraction.mapper.AttractionMapper;
import com.trip.attraction.model.AttractionDto;

@Service
@Transactional
public class AttractionServiceImpl implements AttractionService {
	private AttractionMapper attractionMapper;
	
	public AttractionServiceImpl(AttractionMapper attractionMapper) {
		super();
		this.attractionMapper = attractionMapper;
	}

	@Override
	public List<AttractionDto> attractionListAll() {
		return attractionMapper.attractionListAll();
	}

	@Override
	public List<AttractionDto> attractionListSido(HashMap<String, Integer> map) {
		return attractionMapper.attractionListSido(map);
	}

	@Override
	public List<AttractionDto> attractionListSidoGugun(HashMap<String, Integer> map) {
		return attractionMapper.attractionListSidoGugun(map);
	}

	@Override
	public List<AttractionDto> attractionListTypeId(HashMap<String, Integer> map) {
		return attractionMapper.attractionListTypeId(map);
	}

	@Override
	public List<AttractionDto> attractionListSidoGugunTypeId(HashMap<String, Integer> map) {
		return attractionMapper.attractionListSidoGugunTypeId(map);
	}

}
