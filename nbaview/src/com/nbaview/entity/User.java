package com.nbaview.entity;

/**
 * This class is an entity of user in database.
 * @author Kevin
 */
public class User {
	
	private int id;
	private String email;
	private String username;
	private String password;
	private String tel;
	private String sex;
	private int age;
	private String job;
	private String brief;
	private String level;
	private String signDate;
	private boolean login;
	
	public User() {
		
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getTel() {
		return tel;
	}

	
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	public String getSex() {
		return sex;
	}

	
	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public int getAge() {
		return age;
	}

	
	public void setAge(int age) {
		this.age = age;
	}

	
	public String getJob() {
		return job;
	}

	
	public void setJob(String job) {
		this.job = job;
	}

	
	public String getBrief() {
		return brief;
	}

	
	public void setBrief(String brief) {
		this.brief = brief;
	}

	
	public String getLevel() {
		return level;
	}

	
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	public String getSignDate() {
		return signDate;
	}


	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}


	public boolean getLogin() {
		return login;
	}


	public void setLogin(boolean login) {
		this.login = login;
	}
	
	
	public String toString(){
		return "username: " + username + ",   email: " + email;
	}
	
}
