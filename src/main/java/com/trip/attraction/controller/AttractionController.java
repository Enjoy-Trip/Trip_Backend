package com.trip.attraction.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/list")
	public ResponseEntity<?> attractionListSido(@RequestParam(value = "sidocode", required = false) Integer sidocode, @RequestParam(value = "guguncode", required = false) Integer guguncode, @RequestParam(value = "typeid", required = false) Integer typeid, @RequestParam(value = "keyword", required = false) String keyword) {
		try {
			HashMap<String, String> map = new HashMap<>();
			
			map.put("sidoCode", "" + sidocode);
			map.put("gugunCode", "" + guguncode);
			map.put("typeId", "" + typeid);
			map.put("keyword", keyword);
			
			System.out.println(map);
			
			return new ResponseEntity<List<AttractionDto>>(attractionService.attractionList(map), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
