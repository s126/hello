package s126.hello.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import s126.hello.bean.Account;
import s126.hello.util.DBUtil;


public class LoginDao extends BaseDao {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Query query;
	
	/**
	 * 增加一个新的账号.
	 */
	public boolean addAccount(Account account) {
		String sql = "insert into account (username, password, acctype, birthday, email, phone, sex) values (?, ?, ? , ? , ? , ?, ? )";
		return execute(sql,
				account.getUsername(), account.getPassword(),
				account.getAcctype() == 0 ? 1 : account.getAcctype(),
				new Date(account.getBirthday().getTime()),
				account.getEmail(), account.getPhone(), account.getSex());
	}
	
	
	/**
	 * 获取所有的身份类型，学生、老师等
	 */
	public Map<Integer, String> getAccTypes() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		String sql = "select tid, tname from types";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		return map;
	}


	/**
	 * 获取的登录账号
	 * @param username
	 * @param password
	 */
	public Account checkLogin(String username, String password) {
		String sql = "from Account where username=? and password=?";
		sessionFactory = DBUtil.getSessionFactory();
		session = sessionFactory.openSession();
		query = session.createQuery(sql);
		 query.setString(0, username);
		 query.setString(1, password);
		List ls = query.list();
		session.close();
		sessionFactory.close();
		if(ls !=null && ls.size() > 0)
			return (Account) ls.get(0);
		return null;
	}
	
	public static void main(String[] a){
		System.out.println(new LoginDao().checkLogin("123","123"));
	}

	/**
	 * 检查用户名是否已经存在
	 * @param username
	 */
	public boolean checkEname(String username) {
		return query(Account.class, "select username from account where username = ?", username).size() > 0;
	}
	
}
