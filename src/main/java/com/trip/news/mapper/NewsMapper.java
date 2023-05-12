package com.trip.news.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.news.model.NewsDto;

@Mapper
public interface NewsMapper {
	List<NewsDto> newsList();
}
