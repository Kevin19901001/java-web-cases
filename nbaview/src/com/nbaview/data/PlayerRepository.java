package com.nbaview.data;

import java.util.List;

import com.nbaview.entity.Player;

public interface PlayerRepository {
	
	public boolean save(Player player);
	
	public boolean delete(Player player);
	
	public boolean update(Player player);

	public Player findByName(String playerName);
	
	public List<Player> findByCount(int count);
	
	public List<Player> findAll();
	
}
