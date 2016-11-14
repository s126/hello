package hibernate.query;

import hibernate.BaseTest;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class HQLTest extends BaseTest {

	@Test
	public void empList() {

		Query query = session.createQuery("from Emp");

		List<Emp> EmpList = query.list();

		System.out.println(EmpList);
	}

	@Test
	public void empSave() {
		Dept dept = (Dept) session.get(Dept.class, 30);

		Emp emp = new Emp();
		emp.setEname("李东辉");
		emp.setJob("CLERK");
		emp.setMgr("7653");
		emp.setSal(300.0f);
		emp.setDept(dept);

		session.save(emp);
	}

	@Test
	public void empDelete() {
		// 第一种方法
		// Emp emp = new Emp();
		// emp.setEmpno(1);
		// session.delete(emp);

		// 第二种方法
		// Emp emp = (Emp)session.get(Emp.class, 2);
		// session.delete(emp);

		// 第三种方法
		// Emp emp =
		// (Emp)session.createQuery("from Emp where ename=?").setString(0,
		// "李东辉").uniqueResult();
		// session.delete(emp);

		// 第四种方法
		session.createQuery("delete from Emp where ename=?")
				.setString(0, "李东辉").executeUpdate();

	}

	@Test
	public void empPagesList() {
		// 分页查询，每一页一共5条，我要显示第 2 页的内容
		Query query = session.createQuery("from Emp");

		query.setFirstResult(5);// 显示第几页（起始页）
		query.setMaxResults(5);// 一页显示几条
		List list = query.list();
		for (Object object : list) {
			System.out.println(object);
		}
	}

	@Test
	public void empPagesList2() {
		// 分页查询，第五页
		Query query = session.createQuery("select count(*) from Emp e");
		System.out.println(query.list());	
//		int rs = query.list().size();
//		int pages = (int) Math.ceil(rs / 5.0);
//		query.setFirstResult((pages - 1) * 5);//
//		query.setMaxResults(5);// 一页显示几条
//		List list = query.list();
//		for (Object object : list) {
//			System.out.println(object);
//		}
	}

}
