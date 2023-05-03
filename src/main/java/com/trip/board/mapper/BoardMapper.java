package com.trip.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.board.model.BoardDto;
import com.trip.board.model.CommentDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> boardList();
	BoardDto boardDetail(int boardNo);
	int write(BoardDto boardDto);
	void writeDetail(BoardDto boardDto);
	void writeImages(BoardDto boardDto);
	int writeComment(CommentDto commentDto);
	int updateBoard(BoardDto boardDto);
}
