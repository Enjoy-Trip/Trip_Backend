package com.trip.board.model;

import java.util.List;

import com.trip.comment.model.CommentDto;
import com.trip.user.model.UserDto;

public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardTime;
	private String boardContent;
	private UserDto boardUser;
	private List<String> boardImages;
	private List<CommentDto> commentList;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardTime() {
		return boardTime;
	}

	public void setBoardTime(String boardTime) {
		this.boardTime = boardTime;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public List<String> getBoardImages() {
		return boardImages;
	}

	public void setBoardImages(List<String> boardImages) {
		this.boardImages = boardImages;
	}

	public UserDto getBoardUser() {
		return boardUser;
	}

	public void setBoardUser(UserDto boardUser) {
		this.boardUser = boardUser;
	}

	public List<CommentDto> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentDto> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardTime=" + boardTime
				+ ", boardContent=" + boardContent + ", boardImages=" + boardImages + ", boardUser=" + boardUser
				+ ", commentList=" + commentList + "]";
	}
}
