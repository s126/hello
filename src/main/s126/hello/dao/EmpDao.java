package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import s126.hello.bean.Emp;
import s126.hello.util.DBUtil;

public class EmpDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;

	public List<Emp> getAll() {
		List<Emp> ls = new ArrayList<Emp>();
		String sql = "select empno, ename, job, sal from Emp";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("empno"));
				emp.setSal(rs.getInt("sal"));
				emp.setName(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				ls.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}

	public boolean delete(int empno) {
		boolean bl = false;
		sql = "delete from Emp where empno=?";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			bl = ps.executeUpdate() > 0;
			conn.commit();

		} catch (Exception e) {
			bl = false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return bl;

	}

	public boolean add(Emp emp) throws Exception {
		String sql = "insert into emp (ename,job,sal) values (?, ?, ?)";
		int row = 0;
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getSal());
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return row > 0;
	}

	public List<String> getJobs() {
		List<String> list = new ArrayList<String>();
		String sql = "select distinct job from emp";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				rs.getString(1);
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<Emp> getSome(String input) {
		List<Emp> ls = new ArrayList<Emp>();
		String sql = "select empno, ename, job, sal from Emp where upper(ename) like upper(?) or upper(job) like upper(?)";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + input + "%");
			ps.setString(2, "%" + input + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("empno"));
				e.setSal(rs.getInt("sal"));
				e.setName(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				ls.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public List<Emp> getBySalRange(int min, int max) {
		List<Emp> list = new ArrayList<Emp>();
		sql = "select empno, ename, job, sal from Emp where sal>=? and sal<=? ";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, min);
			ps.setInt(2, max);
			rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt("empno"));
				emp.setSal(rs.getInt("sal"));
				emp.setName(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	
}
