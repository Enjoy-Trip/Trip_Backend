package com.trip.attraction.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trip.response.model.ResponseDto;
import com.trip.attraction.model.AttractionCommentDto;
import com.trip.attraction.model.AttractionDto;
import com.trip.attraction.service.AttractionService;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
	private AttractionService attractionService;
	
	public AttractionController(AttractionService attractionService) {
		super();
		this.attractionService = attractionService;
	}

	@GetMapping("")
	public ResponseEntity<?> attractionList(@RequestParam HashMap<String, String> map) {
		ResponseDto<List<AttractionDto>> response = new ResponseDto<List<AttractionDto>>();
		
		try {
			List<AttractionDto> rst = attractionService.attractionList(map);
			
			response.setState("SUCCESS");
			response.setMessage("여행지 불러오기 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<List<AttractionDto>>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@GetMapping("/{contentid}")
	public ResponseEntity<?> attractionDetail(@PathVariable("contentid") int contentid) {
		ResponseDto<AttractionDto> response = new ResponseDto<AttractionDto>();
		
		try {
			AttractionDto rst = attractionService.attractionDetail(contentid);
			
			if (rst == null) {
				response.setState("FAIL");
				response.setMessage("해당 여행지가 존재하지 않습니다.");
			} else {
				response.setState("SUCCESS");
				response.setMessage("여행지 불러오기 성공");
				response.setData(rst);
			}
			
			return new ResponseEntity<ResponseDto<AttractionDto>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> createAttraction(@RequestBody AttractionDto attractionDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = attractionService.createAttraction(attractionDto);
			
			response.setState("SUCCESS");
			response.setMessage("여행지 생성 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PutMapping(value = "/{contentid}")
	public ResponseEntity<?> updateAttraction(@PathVariable("contentid") int contentid, @RequestBody AttractionDto attractiontDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			AttractionDto attr = attractionService.attractionDetail(contentid);
			
			if (attr == null) {
				response.setState("FAIL");
				response.setMessage("수정하고자 하는 여행지가 존재하지 않습니다.");
			} else {
				attractiontDto.setContentid(contentid);
				
				int rst = attractionService.updateAttraction(attractiontDto);
				
				response.setState("SUCCESS");
				response.setMessage("여행지 수정 성공");
				response.setData(rst);
			}
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@DeleteMapping(value = "/{contentid}")
	public ResponseEntity<?> deleteAttraction(@PathVariable("contentid") int contentid) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			AttractionDto attr = attractionService.attractionDetail(contentid);
			
			if (attr == null) {
				response.setState("FAIL");
				response.setMessage("삭제하고자 하는 여행지가 존재하지 않습니다.");
			} else {
				int rst = attractionService.deleteAttraction(contentid);
				
				response.setState("SUCCESS");
				response.setMessage("여행지 삭제 성공");
				response.setData(rst);
			}
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PostMapping(value = "/comment")
	public ResponseEntity<?> writeAttractionComment(@RequestBody AttractionCommentDto attractionCommentDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = attractionService.writeComment(attractionCommentDto);
			
			response.setState("SUCCESS");
			response.setMessage("댓글 작성 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@PutMapping("/comment/{commentNo}")
	public ResponseEntity<?> updateAttractionComment(@PathVariable("commentNo") int commentNo, @RequestBody AttractionCommentDto attractionCommentDto) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			attractionCommentDto.setAttractionCommentNo(commentNo);
			
			int rst = attractionService.updateComment(attractionCommentDto);
			
			response.setState("SUCCESS");
			response.setMessage("댓글 수정 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
	
	@DeleteMapping("/comment/{commentNo}")
	public ResponseEntity<?> deleteAttractionComment(@PathVariable("commentNo") int commentNo) {
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int rst = attractionService.deleteComment(commentNo);
			
			response.setState("SUCCESS");
			response.setMessage("댓글 삭제 성공");
			response.setData(rst);
			
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("서버에 문제가 발생했습니다.");
			
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
}
