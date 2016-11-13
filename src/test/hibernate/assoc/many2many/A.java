package hibernate.assoc.many2many;

import hibernate.BaseTest;

import org.hibernate.Query;
import org.junit.Test;

public class A extends BaseTest {
	public static void main(String[] args) {
		printddl();
	}
	
	
	@Test
	public void testSave() {
		Student s1 = new Student();
		s1.setName("zhangsan");
		s1.setQq(8888888);
		
		Student s2 = new Student();
		s2.setName("lisier");
		s2.setQq(666666);
		
		Student s3 = new Student();
		s3.setName("wangwuer");
		s3.setQq(7777777);
		
		
		Teacher t1 = new Teacher();
		t1.setName("new");
		t1.setTel("110");
		
		Teacher t2 = new Teacher();
		t2.setName("old");
		t2.setTel("119");
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);

		t2.getStudents().add(s2);
		t2.getStudents().add(s3);
		
		s1.getTeachers().add(t1);
		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);
		s3.getTeachers().add(t2);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		session.save(t1);
		session.save(t2);
		
	}
	
	@Test
	public void testQuery () {
		// Get 方式
        // Teacher teacher = (Teacher) session.get(Teacher.class, 4);
		
		
		
		// Query
		// 1. 创建一个 query 对象。注意， query 是面向对象的写法，所以，参数里是类里的属性
		Query query = session.createQuery("from Teacher r where r.name = :name");
		
		// 2. 绑定参数。注意，参数绑定有两种形式。第一种，序号绑定（?）；第二种，名字绑定(:名字)。
		query.setString("name", "old");
		
		// 3. 获取结果。用 list() 方法，返回所有结果。
		// List<Teacher> teachers = query.list();
		// teachers.get(0);
		// 还有一种方式，主要用于最多只有一个返回结果的情况。是上面语句的一种便捷写法：
		// 注意， query 使用的是链式变成的方法，有点像 jquery。所以，可以把所有代码写在一行中。
		// sesssion.createQuery(hql).setString(0, "xx").setInt(1, "xxx").setEntity("sss", "xxxx").list();
		Teacher teacher = (Teacher) query.uniqueResult();
		
		System.out.println(teacher.getStudents());

	}
	
	
}
