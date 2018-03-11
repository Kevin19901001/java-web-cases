package com.nbaview.data;

import java.util.List;

import com.nbaview.entity.Video;

public interface VideoRepository {
	
	public boolean save(Video video);
	
	public boolean delete(Video video);
	
	public List<Video> findByCount(int count);
	
	public List<Video> findAll();
	
}
