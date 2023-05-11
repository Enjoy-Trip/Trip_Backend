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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> attractionList(@RequestParam(value = "sidocode", required = false) Integer sidocode, @RequestParam(value = "guguncode", required = false) Integer guguncode, @RequestParam(value = "typeid", required = false) Integer typeid, @RequestParam(value = "keyword", required = false) String keyword) {
		try {
			HashMap<String, String> map = new HashMap<>();
			
			map.put("sidoCode", "" + sidocode);
			map.put("gugunCode", "" + guguncode);
			map.put("typeId", "" + typeid);
			map.put("keyword", keyword);
			
			return new ResponseEntity<List<AttractionDto>>(attractionService.attractionList(map), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@GetMapping("/{contentId}")
	public ResponseEntity<?> attractionDetail(@PathVariable("contentId") int contentId) {
		try {
			return new ResponseEntity<AttractionDto>(attractionService.attractionDetail(contentId), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PutMapping("/comment/{commentNo}")
	public ResponseEntity<?> updateAttractionComment(@PathVariable("commentNo") int commentNo, @RequestBody AttractionCommentDto attractionCommentDto) {
		try {
			attractionCommentDto.setCommentNo(commentNo);
			
			System.out.println(attractionCommentDto);
			
			return new ResponseEntity<Integer>(attractionService.updateComment(attractionCommentDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/comment/{commentNo}")
	public ResponseEntity<?> deleteAttractionComment(@PathVariable("commentNo") int commentNo) {
		try {
			return new ResponseEntity<Integer>(attractionService.deleteComment(commentNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
