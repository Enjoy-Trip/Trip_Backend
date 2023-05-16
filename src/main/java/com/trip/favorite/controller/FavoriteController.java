package com.trip.favorite.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.favorite.model.FavoriteDto;
import com.trip.favorite.service.FavoriteService;
import com.trip.response.model.ResponseDto;
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
		ResponseDto<List<FavoriteDto>> response = new ResponseDto<List<FavoriteDto>>();

		try {
			List<FavoriteDto> FavoriteDtoList = favoriteService.myFavoriteList(userNo);
			System.out.println(FavoriteDtoList);
			if(!FavoriteDtoList.isEmpty()) {
				response.setState("SUCCESS");
				response.setMessage("정상적으로 여행지 리스트를 불러 왔습니다.");
				response.setData(FavoriteDtoList);
			}
			else {
				response.setState("FALE");
				response.setMessage("여행지 리스트를 불러오지 못했습니다.");
			}
			return new ResponseEntity<ResponseDto<List<FavoriteDto>>>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			response.setState("FALE");
			response.setMessage("여행지 리스트를 불러오지 못했습니다.");
			return new ResponseEntity<ResponseDto<List<FavoriteDto>>>(response, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	// 여행지별 좋아요 누른 사람들
	@GetMapping(value = "/attraction/{contentid}")
	public ResponseEntity<?> likeUserList(@PathVariable("contentid") int contentid) {
		ResponseDto<List<FavoriteDto>> response = new ResponseDto<List<FavoriteDto>>();

		try {
			List<FavoriteDto> FavoriteDtoList = favoriteService.likeUserList(contentid);
			if(!FavoriteDtoList.isEmpty()) {
				response.setState("SUCCESS");
				response.setMessage("정상적으로 이용자의 리스트를 불러 왔습니다.");
				response.setData(FavoriteDtoList);
			}
			else {
				response.setState("FALE");
				response.setMessage("이용자 리스트를 불러 오지 못했습니다.");
			}
			return new ResponseEntity<ResponseDto<List<FavoriteDto>>>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			response.setState("FALE");
			response.setMessage("이용자 리스트를 불러 오지 못했습니다.");
			return new ResponseEntity<ResponseDto<List<FavoriteDto>>>(response, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
