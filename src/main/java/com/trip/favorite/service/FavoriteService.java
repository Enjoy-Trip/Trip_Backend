package com.trip.favorite.service;

import java.util.List;

import com.trip.favorite.model.FavoriteDto;

public interface FavoriteService {
	List<FavoriteDto> myFavoriteList(int userNo);
	List<FavoriteDto> likeUserList(int contentid);
}
