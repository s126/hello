package com.s126.demo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.s126.demo.bean.Account;
import com.s126.demo.dao.LoginDao;

public class LoginAction  extends ActionSupport{
	
	private String name;
	private String pwd;
	private Account acc = null;
	
	private LoginDao loginDao = new LoginDao();
	
	
	/* 登录功能 */
	public String login ()  {
		acc = loginDao.checkLogin(name, pwd);
		if(acc == null) {
			return "fail";
		}
		ActionContext.getContext().getSession().put("account", acc);
		return SUCCESS;
		
	}
	
	/* 注册功能 */
	public String register () {
		if(!loginDao.addAccount(acc))
			return "fails";
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
