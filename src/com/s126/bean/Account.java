package com.s126.bean;

import java.util.Date;

public class Account {
	
	private String username;
	private String password;
	private int acctype;         // 1, ѧ���˺ţ� 2, ��ʦ�˺ţ� 3, У���˺�.
	private Date lastLogin;   // �ϴεĵ�½ʱ�䡣
	
	
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
