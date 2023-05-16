package com.trip.plan.model;

public class PlanPlaceDto {
	private int contentid;
	private int planDay;
	
	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	public int getPlanDay() {
		return planDay;
	}

	public void setPlanDay(int planDay) {
		this.planDay = planDay;
	}

	@Override
	public String toString() {
		return "PlanPlaceDto [contentid=" + contentid + ", planDay=" + planDay + "]";
	}
}
