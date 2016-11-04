package s126.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import s126.hello.bean.Emp;
import s126.hello.util.DBUtil;

public class EmpDao extends BaseDao {
	
	private List<Emp> ls;
	private Session session;
	private Logger log = Logger.getLogger(EmpDao.class);
	private Query query;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	

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
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 获取所有员工信息getAll()
	 * */
	public List<Emp> getAll(){
		session = DBUtil.getSession();
		ls = session.createQuery("from Emp").list();
		session.close();
		return ls;
	}
	
	/**
	 * 根据条件查询Emp返回List<Emp>
	 * */
	public List<Emp> getSome(String sql, Object...obj){
		try{
			session = DBUtil.getSession();
			query = session.createQuery(sql);
			for (Object object : obj) {
				if(object != null)
					query.setParameter(1, object);
			}
		}catch(Exception e){
			// TODO 这里还没写完  不知道query.set报什么错
			log.info("这里写什么呢？");
			e.printStackTrace();
		}
		ls = query.list();
		session.close();
		return ls;
	}
}
