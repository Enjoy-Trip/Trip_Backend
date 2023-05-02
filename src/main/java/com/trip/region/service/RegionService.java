package com.trip.region.service;

import java.util.List;

import com.trip.region.model.RegionDto;

public interface RegionService {
	List<RegionDto> sidoList();
	List<RegionDto> gugunList(int sidoCode);
}
