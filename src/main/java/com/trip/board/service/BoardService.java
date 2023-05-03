package com.trip.board.service;

import java.util.List;

import com.trip.board.model.BoardDto;

public interface BoardService {
	List<BoardDto> boardList();
	BoardDto boardDetail(int boardNo);
	int write(BoardDto boardDto);
}
