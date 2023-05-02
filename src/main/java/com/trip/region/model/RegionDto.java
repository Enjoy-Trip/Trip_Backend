package com.trip.region.model;

public class RegionDto {
	private int sidoCode;
	private String sidoName;
	private int gugunCode;
	private String gugunName;

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

	public int getgugunCode() {
		return gugunCode;
	}

	public void setgugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getgugunName() {
		return gugunName;
	}

	public void setgugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	@Override
	public String toString() {
		return "RegionDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + ", gugunCode=" + gugunCode
				+ ", gugunName=" + gugunName + "]";
	}
}
