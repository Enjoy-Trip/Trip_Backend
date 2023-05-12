package com.trip.info.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.info.service.InfoService;
import com.trip.info.model.SidoDto;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping(value = "/info")
public class InfoController {
	private InfoService infoService;

	public InfoController(InfoService infoService) {
		super();
		this.infoService = infoService;
	}

	@GetMapping(value = "/sido")
	public ResponseEntity<?> sidoList() {
		try {
			return new ResponseEntity<List<SidoDto>>(infoService.sidoList(), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}

	@GetMapping(value = "/sido/{sidoCode}")
	public ResponseEntity<?> gugunList(@PathVariable("sidoCode") int sidoCode) {
		try {
			return new ResponseEntity<List<SidoDto>>(infoService.sidoDetail(sidoCode), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
