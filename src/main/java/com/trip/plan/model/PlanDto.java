package com.trip.plan.model;

import java.util.List;

import com.trip.user.model.UserDto;

public class PlanDto {
	private UserDto planUser;
	private int planNo;
	private String planStartDate;
	private String planEndDate;
	private String planContent;
	private String planTime;
	private String planTitle;
	private List<PlanPlaceDto> planPlaces;

	public UserDto getPlanUser() {
		return planUser;
	}

	public void setPlanUser(UserDto planUser) {
		this.planUser = planUser;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public List<PlanPlaceDto> getPlanPlaces() {
		return planPlaces;
	}

	public void setPlanPlaces(List<PlanPlaceDto> planPlaces) {
		this.planPlaces = planPlaces;
	}

	@Override
	public String toString() {
		return "PlanDto [planUser=" + planUser + ", planNo=" + planNo + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", planContent=" + planContent + ", planTime=" + planTime
				+ ", planTitle=" + planTitle + ", planPlaces=" + planPlaces + "]";
	}
}
