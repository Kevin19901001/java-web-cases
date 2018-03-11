package com.nbaview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nbaview.service.PlayerService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PlayerController extends HttpServlet {

	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value="/players", method=GET)
	public String showPlayers(Model model, HttpServletRequest request, HttpServletResponse response) {
		String requestCount = request.getParameter("count");
		if (requestCount == null) {
			requestCount = "15";
		}
		int count = Integer.parseInt(requestCount);
		model.addAttribute("playerList", playerService.findByCount(count));
		Enumeration<String> enums = request.getAttributeNames();
		while(enums.hasMoreElements()){
			System.out.println(enums.nextElement());
		}
		return "players";
	}
	
	
	@RequestMapping(value="savePlayer", method=POST)
	public void savePlayer(HttpServletRequest request, HttpServletResponse response) throws IOException{
		boolean isSaved = playerService.savePlayer(request, response);
		if(isSaved){
			response.sendRedirect("/addAPlayer");
		} else {
			response.sendRedirect("/players");
		}
	}
	
}
