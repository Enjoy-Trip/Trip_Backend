package com.trip.searchResult.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.response.model.ResponseDto;
import com.trip.searchResult.model.SearchResultDto;
import com.trip.searchResult.service.SearchResultService;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping("/search-result")
public class SearchResultController {
	private SearchResultService searchResultService;

	public SearchResultController(SearchResultService searchResultService) {
		super();
		this.searchResultService = searchResultService;
	}
	
	//처음에 모든 정보를 리스트로 뿌려주는 역할
	@GetMapping(value = "")
	public ResponseEntity<?> searchResultList() {
		try {
			return new ResponseEntity<List<SearchResultDto>>(searchResultService.searchResultList(), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	//
	@PutMapping(value = "/{word}")
	public ResponseEntity<?> updateSearchResult(@PathVariable("word") String word) {
		try {
			return new ResponseEntity<Integer>(searchResultService.updateSearchResult(word), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	//
	@DeleteMapping(value = "")
	public ResponseEntity<?> deleteSearchResult() {
		try {
			return new ResponseEntity<Integer>(searchResultService.deleteSearchResult(), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
