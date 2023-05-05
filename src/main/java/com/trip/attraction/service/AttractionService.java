package com.trip.attraction.service;

import java.util.HashMap;
import java.util.List;

import com.trip.attraction.model.AttractionDto;

public interface AttractionService {
	List<AttractionDto> attractionList(HashMap<String, String> map);
	AttractionDto attractionDetail(int contentId);
	int deleteComment(int commentNo);
}