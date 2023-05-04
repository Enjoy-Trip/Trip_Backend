package com.trip.attraction.service;

import java.util.HashMap;
import java.util.List;

import com.trip.attraction.model.AttractionDto;

public interface AttractionService {
	List<AttractionDto> attractionListAll();
	List<AttractionDto> attractionListSido(HashMap<String, Integer> map);
	List<AttractionDto> attractionListSidoGugun(HashMap<String, Integer> map);
	List<AttractionDto> attractionListTypeId(HashMap<String, Integer> map);
	List<AttractionDto> attractionListSidoGugunTypeId(HashMap<String, Integer> map);
}
