package test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import s126.hello.bean.Emp;
import s126.hello.dao.BaseDao;
import s126.hello.util.DBUtil;

public class BaseDaoTest {

	@Test
	public void testInsert() throws Exception {
		String sql = "insert into Emp(ename) values('saf')";
		boolean updates = new BaseDao().execute(sql);
		System.out.println(updates);

	}

	@Test
	public void testUpdate() throws Exception {
		String sql = "update emp set ename='zzz' where ename=?";
		boolean updates = new BaseDao().execute(sql, "asd");
		System.out.println(updates);

	}

	@Test
	public void testQuery() throws Exception {
		String sql = "select ename from emp";
		List<Emp> elst = new BaseDao().query(Emp.class, sql);
		System.out.println(elst);
	}
	@Test
	public void testGetSessionFactory(){
		SessionFactory sessionFactory = DBUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Emp> ls = session.createQuery("From Emp").list();
		System.out.println(ls.size());
		for (Emp emp : ls) {
			System.out.println(emp);
		}
	}
}
