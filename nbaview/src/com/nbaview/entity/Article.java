package com.nbaview.entity;

public class Article {

	private int id;
	private String publisher;
	private String pubTime;
	private String title;
	private String content;
	
	public Article() {
		
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getPublisher() {
		return publisher;
	}
	
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	public String getPubTime() {
		return pubTime;
	}
	
	
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
