package com.trip.board.service;

import java.util.List;

import com.trip.board.model.BoardDto;
import com.trip.board.model.CommentDto;

public interface BoardService {
	List<BoardDto> boardList();
	BoardDto boardDetail(int boardNo);
	int write(BoardDto boardDto);
	int writeComment(CommentDto commentDto);
	int updateBoard(BoardDto boardDto);
	int updateComment(CommentDto commentDto);
}
