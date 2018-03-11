package com.nbaview.util;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nbaview.data.UserRepository;
import com.nbaview.entity.User;

import net.sf.json.JSONObject;

/**
 * This controller is to deal with operations about ajax validation.
 * @author Kevin
 *
 */
@Controller
public class UserAjaxValidate extends HttpServlet {
	
	@Autowired
	UserRepository repository;
	
	/**
	 * To check email when user is signing.
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/checkEmail", method=POST)
	public String checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String checkingEmail = request.getParameter("email");
		User user = repository.findByEmail(checkingEmail);
		Map<String, String> checkMap = new HashMap<String, String>();
		
		if (user == null) {
			checkMap.put("textStatus", "suceess");
		} else {
			checkMap.put("textStatus", "error");
		}
		
		JSONObject jsonObject = JSONObject.fromObject(checkMap);
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
	
	/**
	 * To check if the username is unique when user ia signing.
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/checkUsername", method=POST)
	public String checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String checkingUsername = request.getParameter("username");
		User user = repository.findByUsername(checkingUsername);
		Map<String, String> checkMap = new HashMap<String, String>();
		
		if (user == null) {
			checkMap.put("textStatus", "suceess");
		} else {
			checkMap.put("textStatus", "error");
		}
		
		JSONObject jsonObject = JSONObject.fromObject(checkMap);
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
	
	/**
	 * To check if the user is loged in.
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkLoged", method=POST)
	public String checkLogedIn(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Map<String, String> checkMap = new HashMap<String, String>();
		if (username != null) {
			checkMap.put("login", "true");
		} else {
			checkMap.put("login", "false");
		}
		JSONObject jsonObject = JSONObject.fromObject(checkMap);
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
}
