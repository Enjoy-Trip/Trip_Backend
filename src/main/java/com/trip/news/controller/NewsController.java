package com.trip.news.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.news.model.NewsDto;
import com.trip.news.service.NewsService;
import com.trip.response.model.ResponseDto;
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
		ResponseDto<List<NewsDto>> response = new ResponseDto<List<NewsDto>>();
		try {
			
			List<NewsDto> newsList = newsService.newsList();
			if(newsList.size()==0) {
				response.setState("FAIL");
				response.setMessage("불러 올 뉴스가 없습니다.");
			}else {
				response.setState("SUCCESS");
				response.setMessage("뉴스 불러오기 성공 했습니다.");
				response.setData(newsList);
			}
			return new ResponseEntity<ResponseDto<List<NewsDto>>>(response, HttpStatus.OK);
		}catch (Exception e) {
			return ExceptionHandler.exceptionResponse(response, e);
		}
	}
}
