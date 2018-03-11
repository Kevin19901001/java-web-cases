package com.nbaview.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbaview.data.VideoRepository;
import com.nbaview.entity.Video;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	public boolean addVideo(HttpServletRequest request, HttpServletResponse response){
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		String pubTime = request.getParameter("pubtime");
		Video video = new Video();
		video.setTitle(title);
		video.setPublisher(publisher);
		video.setPubTime(pubTime);
		return videoRepository.save(video);
	}
	
	
	public boolean removeVideo(HttpServletRequest request, HttpServletResponse response){
		Video video = new Video();
		String title = request.getParameter("title");
		video.setTitle(title);
		return videoRepository.delete(video);
	}
	
	
	public List<Video> findByCount(int count){
		return videoRepository.findByCount(count);
	}
	
	
	public List<Video> findAll(){
		return videoRepository.findAll();
	}
	
}
