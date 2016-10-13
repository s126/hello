package com.s126.bean;

import java.util.Date;

public class Account {
	
	private String username;
	private String password;
	private int acctype;         // 1, 学生账号； 2, 教师账号； 3, 校长账号.
	private Date lastLogin;   // 上次的登陆时间。
	
	
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
	public int getAcctype() {
		return acctype;
	}
	public void setAcctype(int acctype) {
		this.acctype = acctype;
	}

	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
