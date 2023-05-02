package com.trip.region.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.region.model.RegionDto;
import com.trip.region.service.RegionService;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping(value = "/region")
public class RegionController {
	private RegionService regionService;

	public RegionController(RegionService regionService) {
		super();
		this.regionService = regionService;
	}

	@GetMapping(value = "/sidolist")
	public ResponseEntity<?> sidoList() {
		try {
			return new ResponseEntity<List<RegionDto>>(regionService.sidoList(), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}

	@GetMapping(value = "/gugunlist/{sidoCode}")
	public ResponseEntity<?> gugunList(@PathVariable("sidoCode") int sidoCode) {
		try {
			return new ResponseEntity<List<RegionDto>>(regionService.gugunList(sidoCode), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
