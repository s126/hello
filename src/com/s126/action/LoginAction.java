package com.s126.action;

import com.opensymphony.xwork2.ActionSupport;
import com.s126.bean.Account;
import com.s126.dao.LoginDao;

public class LoginAction  extends ActionSupport{
	
	
	private String name;
	private String pwd;
	private Account acc = null;
	
	private LoginDao loginDao = new LoginDao();
	
	
	public String login ()  {
		acc = loginDao.checkLogin(name, pwd);
		return SUCCESS;
	}
	
	public String register () {
		// Ç·È±ÒµÎñÂß¼­
		loginDao.addAccount(acc);
		return SUCCESS;
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}
	

}
