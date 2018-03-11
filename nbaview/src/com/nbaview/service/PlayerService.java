package com.nbaview.service;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbaview.data.JdbcPlayerRepository;
import com.nbaview.entity.Player;

@Service
public class PlayerService extends HttpServlet {
	
	@Autowired
	JdbcPlayerRepository playerRepository;
	
	public boolean savePlayer(HttpServletRequest request, HttpServletResponse response){
		Player player = new Player();
		player.setAge(Integer.parseInt(request.getParameter("age")));
		player.setBrief(request.getParameter("brief"));
		player.setCity(request.getParameter("city"));
		player.setContract(request.getParameter("contract"));
		player.setFirstName(request.getParameter("firstname"));
		player.setInterest(request.getParameter("interest"));
		player.setLastName(request.getParameter("lastname"));
		player.setNatinality(request.getParameter("natinality"));
		player.setScore(Integer.parseInt(request.getParameter("score")));
		player.setStature(Double.parseDouble(request.getParameter("stature")));
		player.setTeam(request.getParameter("team"));
		player.setWeight(Double.parseDouble(request.getParameter("weight")));
		return playerRepository.save(player);
	}
	
	
	public boolean deletePlayer(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Player player = new Player();
		int playerId = (int) session.getAttribute("userid");
		player.setId(playerId);
		return playerRepository.delete(player);
	}
	
	
	public boolean update(HttpServletRequest request, HttpServletResponse response){
		Player player = new Player();
		player.setAge(Integer.parseInt(request.getParameter("age")));
		player.setBrief(request.getParameter("brief"));
		player.setCity(request.getParameter("city"));
		player.setContract(request.getParameter("contract"));
		player.setFirstName(request.getParameter("firstname"));
		player.setInterest(request.getParameter("interest"));
		player.setLastName(request.getParameter("lastname"));
		player.setNatinality(request.getParameter("natinality"));
		player.setScore(Integer.parseInt(request.getParameter("score")));
		player.setStature(Double.parseDouble(request.getParameter("stature")));
		player.setTeam(request.getParameter("team"));
		player.setWeight(Double.parseDouble(request.getParameter("weight")));
		return playerRepository.update(player);
	}
	
	
	public List<Player> findByCount(int count){
		return playerRepository.findByCount(count);
	}
	
	
	public List<Player> findAll(){
		return playerRepository.findAll();
	}
	
}
