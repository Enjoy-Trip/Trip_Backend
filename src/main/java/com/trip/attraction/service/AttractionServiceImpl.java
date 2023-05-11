package com.trip.attraction.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trip.attraction.mapper.AttractionMapper;
import com.trip.attraction.model.AttractionCommentDto;
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
	public List<AttractionDto> attractionList(HashMap<String, String> map) {
		return attractionMapper.attractionList(map);
	}

	@Override
	public AttractionDto attractionDetail(int contentId) {
		return attractionMapper.attractionDetail(contentId);
	}

	@Override
	public int deleteComment(int commentNo) {
		return attractionMapper.deleteComment(commentNo);
	}

	@Override
	public Integer updateComment(AttractionCommentDto attractionCommentDto) {
		return attractionMapper.updateComment(attractionCommentDto);
	}

}
