package com.trip.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.board.model.BoardDto;
import com.trip.board.service.BoardService;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<?> boardList() {
		try {
			return new ResponseEntity<List<BoardDto>>(boardService.boardList(), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
