package com.trip.news.model;

public class NewsDto {

	private int news_no;
	private String news_title;
	private String news_content;
	private String news_link;
	private String news_image;
	private String news_time;
	
	public int getNews_no() {
		return news_no;
	}
	public void setNews_no(int news_no) {
		this.news_no = news_no;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public String getNews_link() {
		return news_link;
	}
	public void setNews_link(String news_link) {
		this.news_link = news_link;
	}
	public String getNews_image() {
		return news_image;
	}
	public void setNews_image(String news_image) {
		this.news_image = news_image;
	}
	public String getNews_time() {
		return news_time;
	}
	public void setNews_time(String news_time) {
		this.news_time = news_time;
	}
	@Override
	public String toString() {
		return "NewsDto [news_no=" + news_no + ", news_title=" + news_title + ", news_content=" + news_content
				+ ", news_link=" + news_link + ", news_image=" + news_image + ", news_time=" + news_time + "]";
	}

	
	
}