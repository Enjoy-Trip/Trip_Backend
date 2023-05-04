package com.trip.attraction.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.attraction.model.AttractionDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDto> attractionListAll();
	List<AttractionDto> attractionListSido(HashMap<String, Integer> map);
	List<AttractionDto> attractionListSidoGugun(HashMap<String, Integer> map);
	List<AttractionDto> attractionListTypeId(HashMap<String, Integer> map);
	List<AttractionDto> attractionListSidoGugunTypeId(HashMap<String, Integer> map);
}
