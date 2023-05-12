package com.trip.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trip.info.model.SidoDto;

@Mapper
public interface InfoMapper {
	List<SidoDto> sidoList();
	List<SidoDto> sidoDetail(int sidoCode);
}
