package com.nbaview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class TeamController {

	@RequestMapping(value="/teams", method=GET)
	public String showTeams(){
		return "teams";
	}
	
}
