package com.nbaview.entity;

public class Video {
	
	private int id;
	private String title;
	private String publisher;
	private String pubTime;
	
	
	public Video() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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
	
}
