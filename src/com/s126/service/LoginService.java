package com.s126.service;

import com.s126.dao.LoginDao;

public class LoginService {

	private LoginDao loginDao = new LoginDao();
	
	public void login(String name, String pwd) {
		loginDao.checkLogin(name, pwd);
	}

}
