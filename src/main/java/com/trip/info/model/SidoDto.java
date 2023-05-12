package com.trip.info.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SidoDto {
	private int sidoCode;
	private String sidoName;
	private List<GugunDto> gugunList;

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public List<GugunDto> getGugunList() {
		return gugunList;
	}

	public void setGugunList(List<GugunDto> gugunList) {
		this.gugunList = gugunList;
	}

	@Override
	public String toString() {
		return "RegionDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + ", gugunList=" + gugunList + "]";
	}
}
