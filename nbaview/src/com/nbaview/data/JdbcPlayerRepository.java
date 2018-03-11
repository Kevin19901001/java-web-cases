package com.nbaview.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nbaview.entity.Player;

@Repository
public class JdbcPlayerRepository implements PlayerRepository {

	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public boolean save(Player player) {
		String sql = "insert into player (first_name, last_name, age, stature, weight, city, score, nationality, contract, interest, brief, team) values ("
				+ player.getFirstName() + "," + player.getLastName() + ","  + player.getAge() + "," + player.getStature() + "," + player.getWeight() + ","
				+ player.getCity() + "," + player.getScore() + ","  + player.getNatinality() + "," + player.getContract() + "," + player.getInterest() + ","
				+ player.getBrief() + "," + player.getTeam() + ")";
		int flag = jdbcOperations.update(sql);
		if(flag != -1){
			return true;
		}
		return false;
	}


	@Override
	public boolean delete(Player player) {
		String sql = "delete from player where first_name=" + player.getFirstName() + " and last_name=" + player.getLastName();
		int flag = jdbcOperations.update(sql);
		if(flag != -1){
			return true;
		}
		return false;
	}


	@Override
	public boolean update(Player player) {
		String sql = "update player set first_name=" + player.getFirstName() + ",last_name=" + player.getLastName() + ",age=" + 
				player.getAge() + ",stature=" + player.getStature() + ",weight=" + player.getWeight() + ",city=" + player.getCity() + ",score=" + 
				player.getScore() + ",nationality=" + player.getNatinality() + ",contract=" + player.getContract() + ",interest=" + 
				player.getInterest() + ",brief=" + player.getBrief() + ",team=" + player.getTeam();
		int flag = jdbcOperations.update(sql);
		if(flag != -1){
			return true;
		}
		return false;
	}


	@Override
	public Player findByName(String playerName) {
		String sql = "select * from player where first_name=" + playerName;
		List<Player> players = jdbcOperations.query(sql, new PlayerRowMapper());
		if(players.size() > 0){
			return players.get(0);
		}
		return null;
	}

	
	@Override
	public List<Player> findByCount(int count) {
		System.out.println("select by jdbc...");
		String sql = "select * from player limit " + count;
		return jdbcOperations.query(sql, new PlayerRowMapper());
	}
	
	
	@Override
	public List<Player> findAll() {
		String sql = "select * from player order by score";
		return jdbcOperations.query(sql, new PlayerRowMapper());
	}
	
	
	
	private static final class PlayerRowMapper implements RowMapper<Player> {

		@Override
		public Player mapRow(ResultSet result, int rowNum) throws SQLException {
			Player player = new Player();
			player.setId(result.getInt("id"));
			player.setAge(result.getInt("age"));
			player.setBrief(result.getString("brief"));
			player.setCity(result.getString("city"));
			player.setContract(result.getString("contract"));
			player.setFirstName(result.getString("first_name"));
			player.setInterest(result.getString("interest"));
			player.setLastName(result.getString("last_name"));
			player.setNatinality(result.getString("nationality"));
			player.setScore(result.getInt("score"));
			player.setStature(result.getDouble("stature"));
			player.setTeam(result.getString("team"));
			player.setWeight(result.getDouble("weight"));
			return player;
		}
		
	}

}
