package com.trip.info.service;

import java.util.List;

import com.trip.info.model.SidoDto;

public interface InfoService {
	List<SidoDto> sidoList();
	List<SidoDto> sidoDetail(int sidoCode);
}
