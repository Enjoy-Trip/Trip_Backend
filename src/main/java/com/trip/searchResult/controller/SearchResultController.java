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

import com.trip.searchResult.model.SearchResultDto;
import com.trip.searchResult.service.SearchResultService;
import com.trip.util.ExceptionHandler;
import com.trip.util.ResponseDto;

@RestController
@RequestMapping("/search-result")
public class SearchResultController {
	private SearchResultService searchResultService;

	public SearchResultController(SearchResultService searchResultService) {
		super();
		this.searchResultService = searchResultService;
	}
	
	//검색어에 대한 횟수
	@GetMapping(value = "")
	public ResponseEntity<?> searchResultList() {		
		
		ResponseDto<List<SearchResultDto>> response = new ResponseDto<List<SearchResultDto>>();
		
		try {
			List<SearchResultDto> searchResultDtoList= searchResultService.searchResultList();
			if(!searchResultDtoList.isEmpty()) {
				response.setState("SUCCESS");
				response.setMessage("정상적으로 검색어 정보를 불러왔습니다.");
				response.setData(searchResultDtoList);
			}
			else {
				response.setState("FAIL");
				response.setMessage("검색어 정보를 불러오지 못했습니다.");
			}
			return new ResponseEntity<ResponseDto<List<SearchResultDto>>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("검색어 정보를 불러오는 중에 오류가 발생했습니다.");
			return new ResponseEntity<ResponseDto<List<SearchResultDto>>>(response, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	//카운트 늘려주기
	@PutMapping(value = "/{word}")
	public ResponseEntity<?> updateSearchResult(@PathVariable("word") String word) {
		
		ResponseDto<Integer> response = new ResponseDto<Integer>();
		
		try {
			int count = searchResultService.updateSearchResult(word);
			if(count != 0) {
				response.setState("SUCCESS");
				response.setMessage("정상적으로 검색 횟수를 늘렸습니다.");
				response.setData(count);
			}
			else {
				response.setState("FAIL");
				response.setMessage("검색 횟수를 증가시키지 못했습니다.");
			}
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setState("FAIL");
			response.setMessage("검색 횟수를 증가시키는 중에 오류가 발생했습니다.");
			return new ResponseEntity<ResponseDto<Integer>>(response, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	//주기적으로 초기화 할 때 사용.
	@DeleteMapping(value = "")
	public ResponseEntity<?> deleteSearchResult() {
		try {
			return new ResponseEntity<Integer>(searchResultService.deleteSearchResult(), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
