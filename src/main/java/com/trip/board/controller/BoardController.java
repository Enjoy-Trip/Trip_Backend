	package com.trip.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.board.model.BoardDto;
import com.trip.board.model.BoardCommentDto;
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
	
	@GetMapping(value = "")
	public ResponseEntity<?> boardList() {
		try {
			return new ResponseEntity<List<BoardDto>>(boardService.boardList(), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@GetMapping(value = "/{boardNo}")
	public ResponseEntity<?> boardDetail(@PathVariable("boardNo") int boardNo) {
		try {
			return new ResponseEntity<BoardDto>(boardService.boardDetail(boardNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> write(@RequestBody BoardDto boardDto) {
		try {
			return new ResponseEntity<Integer>(boardService.write(boardDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PostMapping(value = "/comment")
	public ResponseEntity<?> writeComment(@RequestBody BoardCommentDto commentDto) {
		try {
			return new ResponseEntity<Integer>(boardService.writeComment(commentDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PutMapping(value = "/{boardNo}")
	public ResponseEntity<?> updateBoard(@PathVariable("boardNo") int boardNo, @RequestBody BoardDto boardDto) {
		try {
			boardDto.setBoardNo(boardNo);
			return new ResponseEntity<Integer>(boardService.updateBoard(boardDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PutMapping(value = "/comment/{commentNo}")
	public ResponseEntity<?> updateComment(@PathVariable("commentNo") int commentNo, @RequestBody BoardCommentDto commentDto) {
		try {
			commentDto.setboardCommentNo(commentNo);
			return new ResponseEntity<Integer>(boardService.updateComment(commentDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@DeleteMapping(value = "/{boardNo}")
	public ResponseEntity<?> delete(@PathVariable("boardNo") int boardNo) {
		try {
			return new ResponseEntity<Integer>(boardService.deleteBoard(boardNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@DeleteMapping(value = "/comment/{commentNo}")
	public ResponseEntity<?> deleteComment(@PathVariable("commentNo") int commentNo) {
		try {
			return new ResponseEntity<Integer>(boardService.deleteComment(commentNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
