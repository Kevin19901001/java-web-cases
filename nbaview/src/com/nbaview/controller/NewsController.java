package com.nbaview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class NewsController {

	@RequestMapping(value="/news", method=GET)
	public String showNewses(){
		return "news";
	}
	
}
