package com.nbaview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class VideoController {

	@RequestMapping(value="/videos", method=GET)
	public String showVideos(){
		return "videos";
	}
	
}
