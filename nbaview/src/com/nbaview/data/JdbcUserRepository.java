package com.nbaview.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nbaview.entity.User;

/**
 * This DAO is to do a series operations about user table in database. 
 * @author Administrator
 *
 */
@Repository
public class JdbcUserRepository implements UserRepository {

	private JdbcOperations jdbcOperations;
	
	public JdbcUserRepository() {
		
	}
	
	
	@Autowired
	public JdbcUserRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	
	/**
	 * To save an user.
	 */
	@Override
	public boolean save(User user) {
		String INSERT_USER = "insert into user (username, password, email, level, signdate) values (?, ?, ?, ?, ?)";
		int i = jdbcOperations.update(INSERT_USER, user.getUsername(), user.getPassword(), user.getEmail(), user.getLevel(), user.getSignDate());
		return i > 0 ? true : false;
	}
	

	/**
	 * To delete an user by id.
	 */
	@Override
	public boolean delete(User user) {
		String DELETE_USER = "delete from user where id=?";
		int i = jdbcOperations.update(DELETE_USER, user.getId());
		return i > 0 ? true : false;
	}
	
	
	/**
	 * To delete an user by username.
	 */
	@Override
	public boolean deleteByUsername(String username){
		String sql = "delete from user where username='" + username + "'";
		int flag = jdbcOperations.update(sql);
		return (flag != -1) ? true : false;
	}
	

	/**
	 * To update an user's info.
	 */
	@Override
	public boolean update(User user) {
		String sql = "update user set email=" + "'" + user.getEmail() + "'" + ",username=" + "'" + user.getUsername() + "'" + ",tel=" + "'" + 
				user.getTel() + "'" + ",sex=" + "'" + user.getSex() + "'" + ",age=" + user.getAge() + ",job=" + "'" + 
				user.getJob() + "'" + ",brief=" + "'" + user.getBrief() + "'" + " where username=" + "'" + user.getUsername() + "'";
		int flag = jdbcOperations.update(sql);
		if(flag != -1){
			return true;
		}
		return false;
	}
	
	
	/**
	 * To update an user's level as manager.
	 */
	@Override
	public boolean addManager(String username){
		String sql = "update user set level='manager' where username='" + username + "'";;
		int flag = jdbcOperations.update(sql);
		return (flag != -1) ? true : false;
	}
	
	
	/***
	 * To update an user's level as common.
	 */
	@Override
	public boolean removeManager(String username){
		String sql = "update user set level='common' where username='" + username + "'";;
		int flag = jdbcOperations.update(sql);
		return (flag != -1) ? true : false;
	}
	

	/**
	 * To find an user by username.
	 */
	@Override
	public User findByUsername(String username) {
		String sql = "select * from user where username=?";
		List<User> users = jdbcOperations.query(sql, new Object[] { username }, new UserRowMapper());
		if (users.size() == 1) {
			User user = users.get(0);
			return user;
		}
		return null;
	}


	/**
	 * To find an user by email.
	 */
	@Override
	public User findByEmail(String email) {
		String sql = "select * from user where email=?";
		List<User> users = jdbcOperations.query(sql, new Object[] { email }, new UserRowMapper());
		if (users.size() == 1) {
			User user = users.get(0);
			return user;
		}
		return null;
	}
	

	/**
	 * To find users by count.
	 */
	public List<User> findByCount(int count, int page){
		String sql = "select * from user where username!='super' order by id limit " + (count * (page - 1)) + ", " + count;
		List<User> users = jdbcOperations.query(sql, new UserRowMapper());
		return users;
	}
	
	
	/**
	 * To find users by user level.
	 */
	@Override
	public List<User> findByLevelManager(){
		String sql = "select * from user where level='manager'";
		List<User> managerUsers = jdbcOperations.query(sql, new UserRowMapper());
		return managerUsers;
	}
	
	
	/**
	 * To find all users.
	 */
	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		List<User> allUsers = jdbcOperations.query(sql, new UserRowMapper());
		return allUsers;
	}

	
	
	/**
	 * To define that how to construct an user when select from database.
	 * @author Kevin
	 */
	private static final class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet result, int rowNum) throws SQLException {
			User user = new User();
			user.setId(Integer.parseInt(result.getString("id")));
			user.setEmail(result.getString("email"));
			user.setUsername(result.getString("username"));
			user.setPassword(result.getString("password"));
			user.setLevel(result.getString("level"));
			user.setTel(result.getString("tel"));
			user.setSex(result.getString("sex"));
			user.setAge(result.getInt("age"));
			user.setJob(result.getString("job"));
			user.setSignDate(result.getString("signdate"));
			user.setBrief(result.getString("brief"));
			return user;
		}
		
	}

}