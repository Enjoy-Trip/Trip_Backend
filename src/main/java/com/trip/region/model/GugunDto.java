package com.trip.region.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GugunDto {
	private int gugunCode;
	private String gugunName;

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	@Override
	public String toString() {
		return "GugunDto [gugunCode=" + gugunCode + ", gugunName=" + gugunName + "]";
	}
}
