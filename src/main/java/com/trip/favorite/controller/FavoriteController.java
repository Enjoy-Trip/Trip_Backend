package com.trip.favorite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.favorite.model.FavoriteDto;
import com.trip.favorite.service.FavoriteService;
import com.trip.util.ExceptionHandler;

@RestController
@RequestMapping("/like")
public class FavoriteController {
	private FavoriteService favoriteService;
	
	public FavoriteController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}
	
	// 내가 좋아요 누른 여행지들
	@GetMapping(value = "/user/{userNo}")
	public ResponseEntity<?> myFavoriteList(@PathVariable("userNo") int userNo) {
		try {
			return new ResponseEntity<List<FavoriteDto>>(favoriteService.myFavoriteList(userNo), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
	
	// 여행지별 좋아요 누른 사람들
	@GetMapping(value = "/attraction/{contentid}")
	public ResponseEntity<?> likeUserList(@PathVariable("contentid") int contentid) {
		try {
			return new ResponseEntity<List<FavoriteDto>>(favoriteService.likeUserList(contentid), HttpStatus.OK);
		} catch (Exception e) {
			return ExceptionHandler.exceptionHandling(e);
		}
	}
}
