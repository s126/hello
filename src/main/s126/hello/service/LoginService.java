package s126.hello.service;

import s126.hello.dao.LoginDao;

public class LoginService {

	private LoginDao loginDao = new LoginDao();
	
	public void login(String name, String pwd) {
		loginDao.checkLogin(name, pwd);
	}
}
