package com.trip.region.service;

import java.util.List;

import com.trip.region.model.SidoDto;

public interface RegionService {
	List<SidoDto> sidoList();
	List<SidoDto> sidoDetail(int sidoCode);
}
