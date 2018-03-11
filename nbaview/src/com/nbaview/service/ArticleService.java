package com.nbaview.service;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbaview.data.ArticleRepository;
import com.nbaview.entity.Article;

@Service
public class ArticleService extends HttpServlet {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	public boolean save(HttpServletRequest request, HttpServletResponse response){
		Article article = new Article();
		String publisher = request.getParameter("publisher");
		String pubTime = request.getParameter("pubtime");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		article.setPublisher(publisher);
		article.setPubTime(pubTime);
		article.setTitle(title);
		article.setContent(content);
		return articleRepository.save(article);
	}
	
	
	public boolean delete(HttpServletRequest request, HttpServletResponse response){
		String title  = request.getParameter("title");
		Article article = new Article();
		article.setTitle(title);
		return articleRepository.delete(article);
	}
	
	
	public List<Article> findByCount(int count){
		return articleRepository.findByCount(count);
	}
	
	
	public List<Article> ffindAll(){
		return articleRepository.findAll();
	}
	
}
