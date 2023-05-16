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

import com.trip.response.model.ResponseDto;
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
		ResponseDto<List<BoardDto>> response = new ResponseDto<List<BoardDto>>();
		
		try {
			List<BoardDto> rst = boardService.boardList();
			
			response.setState("SUCCESS");
			response.setMessage("게시글 불러오기 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<List<BoardDto>>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("게시글을 불러오는 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@GetMapping(value = "/{boardNo}")
	public ResponseEntity<?> boardDetail(@PathVariable("boardNo") int boardNo) {
		ResponseDto<BoardDto> response = new ResponseDto<BoardDto>();
		
		try {
			BoardDto board = boardService.boardDetail(boardNo);
			
			if (board == null) {
				response.setState("FAIL");
				response.setMessage("해당 게시글이 존재하지 않습니다.");
			} else {
				response.setState("SUCCESS");
				response.setMessage("게시글 불러오기 성공");
				response.setData(board);
			}
			
			return new ResponseEntity<ResponseDto<BoardDto>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("게시글을 불러오는 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> write(@RequestBody BoardDto boardDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = boardService.write(boardDto);
			
			response.setState("SUCCESS");
			response.setMessage("게시글 작성 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("게시글을 작성 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PostMapping(value = "/comment")
	public ResponseEntity<?> writeComment(@RequestBody BoardCommentDto commentDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = boardService.writeComment(commentDto);
			
			response.setState("SUCCESS");
			response.setMessage("댓글 작성 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("댓글 작성 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PutMapping(value = "/{boardNo}")
	public ResponseEntity<?> updateBoard(@PathVariable("boardNo") int boardNo, @RequestBody BoardDto boardDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			BoardDto board = boardService.boardDetail(boardNo);
			
			if (board == null) {
				response.setState("FAIL");
				response.setMessage("해당 게시물이 존재하지 않습니다.");
			} else {
				boardDto.setBoardNo(boardNo);
				
				int rst = boardService.updateBoard(boardDto);
				
				response.setState("SUCCESS");
				response.setMessage("게시글 수정 성공");
				response.setData(rst);
			}
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("게시글을 수정 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PutMapping(value = "/comment/{commentNo}")
	public ResponseEntity<?> updateComment(@PathVariable("commentNo") int commentNo, @RequestBody BoardCommentDto commentDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			BoardCommentDto comment = boardService.getBoardComment(commentNo);
			
			if (comment == null) {
				response.setState("FAIL");
				response.setMessage("해당 댓글이 존재하지 않습니다.");
			} else {
				commentDto.setboardCommentNo(commentNo);
				
				int rst = boardService.updateComment(commentDto);
				
				response.setState("SUCCESS");
				response.setMessage("댓글 수정 성공");
				response.setData(rst);
			}
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("댓글 수정 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@DeleteMapping(value = "/{boardNo}")
	public ResponseEntity<?> delete(@PathVariable("boardNo") int boardNo) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = boardService.deleteBoard(boardNo);
			
			response.setState("SUCCESS");
			response.setMessage("게시글 삭제 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("게시글을 삭제 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@DeleteMapping(value = "/comment/{commentNo}")
	public ResponseEntity<?> deleteComment(@PathVariable("commentNo") int commentNo) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = boardService.deleteComment(commentNo);
			
			response.setState("SUCCESS");
			response.setMessage("댓글 삭제 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("댓글 삭제 중 오류가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
}
