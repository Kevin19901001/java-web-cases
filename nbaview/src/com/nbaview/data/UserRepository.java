package com.nbaview.data;

import java.util.List;

import com.nbaview.entity.User;

public interface UserRepository {
	
	public boolean save(User user);
	
	public boolean delete(User user);
	
	public boolean deleteByUsername(String username);
	
	public boolean update(User user);
	
	public boolean addManager(String username);
	
	public boolean removeManager(String username);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);

	public List<User> findByCount(int count, int page);
	
	public List<User> findByLevelManager();

	List<User> findAll();
	
}
