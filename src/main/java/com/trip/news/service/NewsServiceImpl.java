package com.trip.news.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.news.mapper.NewsMapper;
import com.trip.news.model.NewsDto;

@Service
public class NewsServiceImpl implements NewsService {

	private NewsMapper newsMapper;
	
	public NewsServiceImpl(NewsMapper newsMapper) {
		super();
		this.newsMapper = newsMapper;
	}

	@Override
	public List<NewsDto> newsList() {
		return newsMapper.newsList();
	}

}
