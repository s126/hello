package s126.hello.service;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import s126.hello.bean.Account;
import s126.hello.dao.LoginDao;

public class LoginService {

	private LoginDao loginDao = new LoginDao();

	public boolean checkEname(String username) {
		return loginDao.checkEname(username);
	}

	public Account checkLogin(String username, String password) {
		List<Account> acclist = loginDao.checkLogin(username, password);
		return acclist.size() > 0 ? acclist.get(0) : null;
	}

	public Object getAccTypes() {
		return loginDao.getAccTypes();
	}

	public boolean addAccount(Account account) {
		return loginDao.addAccount(account);
	}

	public static void logout() {
		ServletActionContext.getRequest().getSession().invalidate();
	}
}




