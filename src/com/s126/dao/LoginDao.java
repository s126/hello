package com.s126.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s126.bean.Account;
import com.s126.util.DBUtil;

public class LoginDao {

	/**
	 * 检查用户是否存在。如果存在的话，返回  Account 信息，否则，返回 null。
	 */
	public Account checkLogin(String name, String pwd) {
		Connection conn = DBUtil.getCon();
		String sql = "select username, acctype, lastlogin from account where username=? and password=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				account = new Account();
				account.setUsername(rs.getString(1));
				account.setAcctype(rs.getInt(2));
				account.setLastLogin(rs.getTimestamp(3));
			}
			
		} catch (Exception e) {
		}
		
		return account;
	}
	
	
	/**
	 * 
	 */
	public boolean addAccount (Account account) {
		Connection conn = DBUtil.getCon();
		String sql = "insert into account (username, password, acctype) values (?, ?, ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn.setAutoCommit(false);
			// 第一個插入操作
			
			// 第二個插入操作
			
			// 第三個更新操作
			ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setInt(3, account.getAcctype() == 0 ? 1 : account.getAcctype());
			
			ps.execute();
			conn.commit();
			
			return true;
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			return false;
			
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
	}
	
	public static void main(String[] args) {
		LoginDao loginDao = new LoginDao();
		System.out.println(loginDao.checkLogin("zhouqiang", "1234567"));
	}

}
