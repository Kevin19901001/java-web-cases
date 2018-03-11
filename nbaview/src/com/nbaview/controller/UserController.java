package com.nbaview.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nbaview.entity.User;
import com.nbaview.service.UserService;

import net.sf.json.JSONObject;

/**
 * This controller is to do a series of operation about user.
 * @author Kevin
 */
@Controller
public class UserController extends HttpServlet {
	
	@Autowired
	UserService userService;
	
	/**
	 * To return the signup page.
	 * @return
	 */
	@RequestMapping(value="/signup", method=GET)
	public String signup(){
		return "signup";
	}
	
	
	/**
	 * After signup, to add a user.
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/addUser", method=POST)
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (userService.addUser(request, response)) {
			response.sendRedirect("/nbaview/login");
		} else {
			response.sendRedirect("/");
		}
	}
	
	
	/**
	 * To return the login page.
	 * @return
	 */
	@RequestMapping(value="/login", method=GET)
	public String userLogin(){
		return "login";
	}
	
	
	/**
	 * To check the user info for login.
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/checkLogin", method=POST)
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		User user = userService.findByUsername(request, response);
		HttpSession session = request.getSession(true);
		session.setAttribute("username", user.getUsername());
		session.setAttribute("userid", user.getId());
		session.setAttribute("userLevel", user.getLevel());
		if ((user != null) && (request.getParameter("password").equals(user.getPassword()))) {
			user.setLogin(true);
			response.sendRedirect("/nbaview/");
		} else {
			response.sendRedirect("/nbaview/failed");
		}
	}
	
	
	/**
	 * To return the failed page if login failed. 
	 * @return
	 */
	@RequestMapping(value="/failed", method=GET)
	public String loginFailed(){
		return "failed";
	}
	
	
	/**
	 * For the situation logout.
	 * @return
	 */
	@RequestMapping(value="/logout", method=GET)
	public String logout(){
		return "logout";
	}
	
	
	/**
	 * The user's own zone.
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/mine", "/showAllUsers"}, method=GET)
	public String showMyZone(HttpServletRequest request, HttpServletResponse response, Model model){
		HttpSession session = request.getSession();
		String userLevel = (String) session.getAttribute("userLevel");
		String username = (String) session.getAttribute("username");
		if(userLevel.equals("common")){
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
			return "single_user_page";
		} else if(userLevel.equals("manager")){
			return "manager_mine";
		} else {
			int allUserCount = userService.findAll().size();
			int pageCount;
			if(((allUserCount%10) > 0)){
				pageCount = (allUserCount/10) + 1;
			} else {
				pageCount = (allUserCount/10);
			}
			
			request.setAttribute("pageCount", pageCount);
			
			int[] pageTags = new int[pageCount];
			for(int i = 0; i < pageCount; i++){
				pageTags[i] = i + 1;
			}
			
			int page;
			if((request.getParameter("page") == null) || (request.getParameter("page") == "0")){
				page = 1;
			}else{
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			model.addAttribute("currentPage", page);
			model.addAttribute("pageTags", pageTags);
			List<User> userList = userService.findByCount(request, response);
			model.addAttribute("userList", userList);
			return "all_users_page";
		}
	}
	
	
	/**
	 * To return the managers view.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showManagerUsers", method=GET)
	public String showManagerUsers(Model model){
		List<User> managerList = userService.findByLevelManager();
		model.addAttribute("managerList", managerList);
		return "manager_users_page";
	}
	
	
	/**
	 * To return the search view.
	 * @return
	 */
	@RequestMapping(value="/search", method=GET)
	public String search(){
		return "search_user_page";
	}
	
	
	/**
	 * to return to search result view.
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchOneUser")
	public String searchOneUser(HttpServletRequest request, HttpServletResponse response, Model model){
		User searchedUser = new User();
		User user = userService.findByUsername(request, response);
		searchedUser.setId(user.getId());
		searchedUser.setUsername(user.getUsername());
		searchedUser.setEmail(user.getEmail());
		searchedUser.setTel(user.getTel());
		searchedUser.setLevel(user.getLevel());
		searchedUser.setSignDate(user.getSignDate());
		model.addAttribute("searchedUser", searchedUser);
		return "search_one_user_page";
	}
	
	
	/**
	 * To response the ajax request for  updating user's info.
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/updateUser", method=POST)
	public String updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		boolean isUpdated = userService.updateUser(request, response);
		Map<String, String> checkMap = new HashMap<String, String>();
		if(isUpdated){
			checkMap.put("isUpdated", "true");
		} else {
			checkMap.put("isUpdated", "yes");
		}
		JSONObject jsonObject = JSONObject.fromObject(checkMap);
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
	
	/**
	 * To return the page for modyfying user info.
	 * @return
	 */
	@RequestMapping(value="/modifyOwnInfo", method=GET)
	public String modifyUser(HttpServletRequest request, HttpServletResponse response, Model model){
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "modify_user";
	}
	
	
	/**
	 * To return the page for adding a player.
	 * @return
	 */
	@RequestMapping(value="addAPlayer", method=GET)
	public String addAPlayer(){
		return "add_player";
	}
	
	
	/**
	 * To return the page for adding a news.
	 * @return
	 */
	@RequestMapping(value="/addANews", method=GET)
	public String addPlayer(){
		return "add_article";
	}
	
	
	/**
	 * To return a page for user to add a video.
	 * @return
	 */
	@RequestMapping(value="/addAVideo", method=GET)
	public String addVideo(){
		return "add_video";
	}
	
	
	/**
	 * To response the ajax request for deleting a user.
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteUser", method=POST)
	public String deleteUser(HttpServletRequest request, HttpServletResponse response) {
		boolean isDeleted = userService.deleteByUsername(request, response);
		Map<String, String> checkMap = new HashMap<String, String>();
		if (isDeleted) {
			checkMap.put("isDeleted", "yes");
		} else {
			checkMap.put("isDeleted", "no");
		}
		JSONObject jsonObject = JSONObject.fromObject(checkMap);
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
	
	/**
	 * To response the ajax request for updating a user as manager user.
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addManager", method=POST)
	public String addManager(HttpServletRequest request, HttpServletResponse response){
		boolean isAdded = userService.addManager(request, response);
		Map<String, String> checkMap = new HashMap<String, String>();
		if (isAdded) {
			checkMap.put("isAdded", "yes");
			User user = userService.findByUsername(request, response);
			String userLevel = user.getLevel();
			checkMap.put("level", userLevel);
		} else {
			checkMap.put("isAdded", "no");
		}
		JSONObject jsonObject = JSONObject.fromObject(checkMap);
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
	
	/**
	 * To response a ajax request for updaing a user as common user.
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/removeManager", method=POST)
	public String removeManager(HttpServletRequest request, HttpServletResponse response){
		boolean isRemoved = userService.removeManager(request, response);
		Map<String, String> checkMap = new HashMap<String, String>();
		if (isRemoved) {
			checkMap.put("isRemoved", "yes");
		} else {
			checkMap.put("isRemoved", "no");
		}
		JSONObject jsonObject = JSONObject.fromObject(checkMap);
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
}
