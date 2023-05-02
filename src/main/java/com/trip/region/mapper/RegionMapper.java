package com.trip.region.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.region.model.RegionDto;

@Mapper
public interface RegionMapper {
	List<RegionDto> sidoList();
	List<RegionDto> gugunList(int sidoCode);
}
