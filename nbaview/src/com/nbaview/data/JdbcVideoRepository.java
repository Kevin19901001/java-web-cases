package com.nbaview.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nbaview.entity.Video;

@Repository
public class JdbcVideoRepository implements VideoRepository {

	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Override
	public boolean save(Video video) {
		String sql = "insert into video values (" + video.getTitle() + ", " + video.getPublisher() + ", " + video.getPubTime() + ")";
		int flag = jdbcOperations.update(sql);
		if (flag != -1) {
			return true;
		}
		return false;
	}

	
	@Override
	public boolean delete(Video video) {
		String sql = "delete from video where title=" + video.getTitle();
		int flag = jdbcOperations.update(sql);
		if (flag != -1) {
			return true;
		}
		return false;
	}

	
	@Override
	public List<Video> findByCount(int count) {
		String sql = "select * from video limit " + count;
		List<Video> videos = jdbcOperations.query(sql, new VideoRowMapper());
		return videos;
	}

	
	@Override
	public List<Video> findAll() {
		String sql = "select * from video";
		List<Video> allVideos = jdbcOperations.query(sql, new VideoRowMapper());
		return allVideos;
	}
	
	
	
	private static final class VideoRowMapper implements RowMapper<Video> {

		@Override
		public Video mapRow(ResultSet result, int rowNum) throws SQLException {
			Video video = new Video();
			video.setId(result.getInt("id"));
			video.setPublisher(result.getString("publisher"));
			video.setPubTime(result.getString("pubtime"));
			video.setTitle(result.getString("title"));
			return video;
		}
		
	}

}
