package com.trip.news.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.news.model.NewsDto;
import com.trip.news.service.NewsService;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping("/news")
public class NewsController {

	private NewsService newsService;

	public NewsController(NewsService newsService) {
		super();
		this.newsService = newsService;
	}

	@GetMapping(value = "")
	public ResponseEntity<?> newsList(){
		try {
			return new ResponseEntity<List<NewsDto>>(newsService.newsList(), HttpStatus.OK);
		}catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
