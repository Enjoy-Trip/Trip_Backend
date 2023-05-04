package com.trip.attraction.model;

import com.trip.user.model.UserDto;

public class AttractionCommentDto {
	private int commentNo;
	private int contentId;
	private String content;
	private String time;
	private UserDto commentUser;

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public UserDto getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(UserDto commentUser) {
		this.commentUser = commentUser;
	}

	@Override
	public String toString() {
		return "AttractionCommentDto [commentNo=" + commentNo + ", contentId=" + contentId + ", content=" + content
				+ ", time=" + time + ", commentUser=" + commentUser + "]";
	}
}
