package com.trip.board.model;

import com.trip.user.model.UserDto;

public class CommentDto {
	private int commentNo;
	private String commentContent;
	private String commentTime;
	private UserDto commentUser;

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public UserDto getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(UserDto commentUser) {
		this.commentUser = commentUser;
	}

	@Override
	public String toString() {
		return "CommentDto [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentTime="
				+ commentTime + ", commentUser=" + commentUser + "]";
	}
}
