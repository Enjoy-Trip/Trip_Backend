package com.trip.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.board.model.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> boardList();
}
