package com.trip.board.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trip.user.model.UserDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardCommentDto {
	private int boardCommentNo;
	private int boardNo;
	private String boardCommentContent;
	private String boardCommentTime;
	private UserDto boardCommentUser;

	public int getboardCommentNo() {
		return boardCommentNo;
	}

	public void setboardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getboardCommentContent() {
		return boardCommentContent;
	}

	public void setboardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}

	public String getboardCommentTime() {
		return boardCommentTime;
	}

	public void setboardCommentTime(String boardCommentTime) {
		this.boardCommentTime = boardCommentTime;
	}

	public UserDto getboardCommentUser() {
		return boardCommentUser;
	}

	public void setboardCommentUser(UserDto boardCommentUser) {
		this.boardCommentUser = boardCommentUser;
	}

	@Override
	public String toString() {
		return "CommentDto [boardCommentNo=" + boardCommentNo + ", boardNo=" + boardNo + ", boardCommentContent=" + boardCommentContent
				+ ", boardCommentTime=" + boardCommentTime + ", boardCommentUser=" + boardCommentUser + "]";
	}
}
