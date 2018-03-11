package com.nbaview.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.nbaview.data.UserRepository;
import com.nbaview.entity.User;

/**
 * This service is to deal with user operations.
 * @author Kevin
 */
@Service
public class UserService extends HttpServlet {

	@Autowired
	UserRepository userRepository;
	
	/**
	 * To add a user to database table.
	 * @param request
	 * @param response
	 * @return boolean
	 */
	public boolean addUser(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		if (request.getParameter("username").equals("super")) {
			user.setLevel("super");
		} else {
			user.setLevel("common");
		}
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatedDate = formater.format(date);
		user.setSignDate(formatedDate);
		return userRepository.save(user);
	}
	
	
	/**
	 * To delete an user.
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean deleteUser(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		User user = new User();
		user.setUsername(username);
		return userRepository.delete(user);
	}
	
	
	/**
	 * To delete an user by username.
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean deleteByUsername(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		return userRepository.deleteByUsername(username);
	}
	
	
	/**
	 * To update an user's info.
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean updateUser(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String level = request.getParameter("level");
		String tel = request.getParameter("tel");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		String brief = request.getParameter("brief");
		User user = new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setLevel(level);
		user.setTel(tel);
		user.setSex(sex);
		user.setAge(age);
		user.setJob(job);
		user.setBrief(brief);
		return userRepository.update(user);
	}
	
	
	/**
	 * To update an user as manager user.
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean addManager(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		return userRepository.addManager(username);
	}
	
	
	/**
	 * To update an user as common user.
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean removeManager(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		return userRepository.removeManager(username);
	}
	
	
	/**
	 * To find an user by username.
	 * @param request
	 * @param response
	 * @return
	 */
	public User findByUsername(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		User user = userRepository.findByUsername(username);
		return user;
	}
	
	
	/**
	 * To find an user by username.
	 * @param username
	 * @return
	 */
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	
	/**
	 * To find users by count.
	 * @param request
	 * @param response
	 * @return
	 */
	public List<User> findByCount(HttpServletRequest request, HttpServletResponse response){
		int count;
		if((request.getParameter("count") == null) || (request.getParameter("count") == "0")){
			count = 10;
		}else{
			count = Integer.parseInt(request.getParameter("count"));
		}
		int page;
		if((request.getParameter("page") == null) || (request.getParameter("page") == "0")){
			page = 1;
		}else{
			page = Integer.parseInt(request.getParameter("page"));
		}
		return userRepository.findByCount(count, page);
	}
	
	
	/**
	 * To find users who's level is manager.
	 * @return
	 */
	public List<User> findByLevelManager(){
		return userRepository.findByLevelManager();
	}
	
	
	/**
	 * To find all users.
	 * @return
	 */
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}
