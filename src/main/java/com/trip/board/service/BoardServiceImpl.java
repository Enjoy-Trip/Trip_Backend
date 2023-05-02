package com.trip.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.board.mapper.BoardMapper;
import com.trip.board.model.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardMapper boardMapper;

	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardDto> boardList() {
		return boardMapper.boardList();
	}

	@Override
	public BoardDto boardDetail(int boardNo) {
		return boardMapper.boardDetail(boardNo);
	}
}
