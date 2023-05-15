package com.trip.plan.model;

public class PlanDto {

	private int userNo;
	private int planNo;
	private String planStartDate;
	private String planEndDate;
	private String planContent;
	private String planTime;
	private String planTitle;
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	@Override
	public String toString() {
		return "PlanDto [userNo=" + userNo + ", planNo=" + planNo + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", planContent=" + planContent + ", planTime=" + planTime
				+ ", planTitle=" + planTitle + "]";
	}
	
	
}
