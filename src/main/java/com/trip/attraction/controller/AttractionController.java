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
	public ResponseEntity<?> attractionList(@RequestParam(value = "areacode", required = false) Integer areacode, @RequestParam(value = "sigungucode", required = false) Integer sigungucode, @RequestParam(value = "contenttypeid", required = false) Integer contenttypeid, @RequestParam(value = "keyword", required = false) String keyword) {
		try {
			HashMap<String, String> map = new HashMap<>();
			
			map.put("areacode", "" + areacode);
			map.put("sigungucode", "" + sigungucode);
			map.put("contenttypeid", "" + contenttypeid);
			map.put("keyword", keyword);
			
			return new ResponseEntity<List<AttractionDto>>(attractionService.attractionList(map), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@GetMapping("/{contentid}")
	public ResponseEntity<?> attractionDetail(@PathVariable("contentid") int contentid) {
		try {
			return new ResponseEntity<AttractionDto>(attractionService.attractionDetail(contentid), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PostMapping(value = "")
	public ResponseEntity<?> createAttraction(@RequestBody AttractionDto attractionDto) {
		try {
			return new ResponseEntity<Integer>(attractionService.createAttraction(attractionDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PostMapping(value = "/comment")
	public ResponseEntity<?> writeAttractionComment(@RequestBody AttractionCommentDto attractionCommentDto) {
		try {
			return new ResponseEntity<Integer>(attractionService.writeComment(attractionCommentDto), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	@PutMapping("/comment/{commentNo}")
	public ResponseEntity<?> updateAttractionComment(@PathVariable("commentNo") int commentNo, @RequestBody AttractionCommentDto attractionCommentDto) {
		try {
			attractionCommentDto.setAttractionCommentNo(commentNo);
			
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
