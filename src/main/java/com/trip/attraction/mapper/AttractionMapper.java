package com.trip.attraction.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.attraction.model.AttractionCommentDto;
import com.trip.attraction.model.AttractionDto;

@Mapper
public interface AttractionMapper {
	List<AttractionDto> attractionList(HashMap<String, String> map);
	AttractionDto attractionDetail(int contentid);
	int updateComment(AttractionCommentDto attractionCommentDto);
	int deleteComment(int contentId);
}
