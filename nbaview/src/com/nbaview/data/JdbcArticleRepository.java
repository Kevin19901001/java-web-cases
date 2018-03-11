package com.nbaview.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nbaview.entity.Article;

@Repository
public class JdbcArticleRepository implements ArticleRepository {

	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Override
	public boolean save(Article article) {
		String sql = "insert into article (publisher, pubtime, title, content) values (" + article.getPublisher() + ", " + article.getPubTime() + ", "
				+ article.getTitle() + ", " + article.getContent() + ")";
		int flag = jdbcOperations.update(sql);
		if(flag != -1){
			return true;
		}
		return false;
	}

	
	@Override
	public boolean delete(Article article) {
		String sql = "delete from article where title=" + article.getTitle();
		int flag = jdbcOperations.update(sql);
		if(flag != -1){
			return true;
		}
		return false;
	}

	
	@Override
	public Article findByTitle(String title) {
		String sql = "select * from article where title=" + title;
		List<Article> articles = jdbcOperations.query(sql, new ArticleRowMapper());
		if(articles.size() != 0){
			return articles.get(0);
		}
		return null;
	}

	
	@Override
	public List<Article> findByCount(int count) {
		String sql = "select * from article limit" + count;
		List<Article> articles = jdbcOperations.query(sql, new ArticleRowMapper());
		return articles;
	}

	
	@Override
	public List<Article> findAll() {
		String sql = "select * from artecle";
		List<Article> articles = jdbcOperations.query(sql, new ArticleRowMapper());
		return articles;
	}
	
	
	
	private static final class ArticleRowMapper implements RowMapper<Article> {

		@Override
		public Article mapRow(ResultSet result, int rowNum) throws SQLException {
			Article article = new Article();
			article.setContent(result.getString("content"));
			article.setId(result.getInt("id"));
			article.setPublisher(result.getString("publisher"));
			article.setPubTime(result.getString("pubtime"));
			article.setTitle(result.getString("title"));
			return article;
		}
		
	}

}
