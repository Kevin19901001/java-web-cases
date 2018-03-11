package com.nbaview.data;

import java.util.List;

import com.nbaview.entity.Article;

public interface ArticleRepository {
	
	public boolean save(Article article);
	
	public boolean delete(Article article);
	
	public Article findByTitle(String title);
	
	public List<Article> findByCount(int count);
	
	public List<Article> findAll();
	
}
