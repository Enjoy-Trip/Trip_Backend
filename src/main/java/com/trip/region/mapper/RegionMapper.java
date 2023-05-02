package com.trip.region.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.region.model.SidoDto;

@Mapper
public interface RegionMapper {
	List<SidoDto> sidoList();
	List<SidoDto> sidoDetail(int sidoCode);
}
