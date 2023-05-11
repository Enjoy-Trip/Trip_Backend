package com.trip.searchResult.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.searchResult.model.SearchResultDto;

@Mapper
public interface SearchResultMapper {
	List<SearchResultDto> getSearchResultList();
	int getSearchResultCount(String word);
}
