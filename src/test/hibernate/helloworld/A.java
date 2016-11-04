package hibernate.helloworld;

import hibernate.BaseTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.junit.Test;

import s126.hello.util.DBUtil;


/**
 * hibernate 的基本语法，简单使用
 */

public class A extends BaseTest {
	
	@Test
	public void testJDBC() throws SQLException {
		// jdbc 连接数据库示例
		
		// 初始化 Connection		
		Connection conn = DBUtil.getConn();
		
		// 设置事务
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("insert into author (aid, name, birth) values (999, 'jdbctest', null)");
		
		// 向数据库发送插入数据的请求
		// flush
		ps.execute();
		
		// 提交事务
		conn.commit();
		
		// 关闭资源
		ps.close();
		conn.close();
	}

	@Test
	public void testFlush() {
		// 同步 session 缓存
		
		// 初始化对象
		Author author = new Author();
		author.setName("struts....");
		author.setBirth(new Date());
		
		// 数据只是存在于 session 的缓存中
		session.save(author);
		
		// 向数据库发送插入数据的命令，相当于 jdbc 中的 ps.execute()
		// 但是 flush 不会去操作事务
  		// session.flush();
		
		// 查询会触发 flush()
		Query query = session.createQuery("from Author");
		System.out.println(query.list().size());
		
		System.out.println("ssss");
	}
	
	@Test
	public void testRefresh() {
		// 更新缓存
		
		// 检索数据
		Author author = (Author) session.get(Author.class, 35);
		
		session.refresh(author);
		
		// 打印数据
		System.out.println(author.getName());
		
	}
	
	@Test
	public void testClear() {
		// 清空session
		
		Author author = new Author();
		author.setName("屈原");
		
		System.out.println(author.hashCode());
		
		session.save(author);

		// session 清空所有的缓存数据
		session.clear();
		
		author = new Author();
		author.setName("quyuan");
		
		System.out.println(author.hashCode());

		session.save(author);
	}
	
	
	@Test
	public void testEvict() {
		// 清空特定对象的缓存
		
		Author author = new Author();
		author.setName("曹雪芹");
		

		Author author2 = new Author();
		author2.setName("罗贯中");
		
		session.save(author);
		session.save(author2);
		
		session.flush();
		
		// 只清空特定类的缓存
		session.evict(author2);
		
		System.out.println(author2);
	}
	
	
	@Test
	public void testGet() {
		// 根据主键，查询数据。单条返回结果
		Author author = (Author) session.get(Author.class, 1);
		System.out.println("==============");
		System.out.println(author);
	}
	
	@Test
	public void testLoad() {
		// 根据主键，查询数据。单条返回结果
		
		// get 跟 load 的区别如下：
		// 1. 如果查询的数据不存在的话，那么 get 会返回 null，而 load 会抛出异常。
		// 2. get 是立即从数据库中检索数据； load 是懒加载，即只有当要使用对象的时刻，才进行加载，懒加载是通过代理实现的。
		// 3. get 会直接连接数据库查询； load 会首先尝试从缓存中获取数据。
		Author author = (Author) session.load(Author.class, 1);
		System.out.println("=====================");
		System.out.println(author);
	}
	
	@Test
	public void testSave() throws ParseException {
		// save 保存一条数据
		
		// 首先，初始化对象
		Author author = new Author();
		author.setName("张小花");
		author.setBirth(new Date());
		
		// 其次，初始化 Session，开启 Transaction
		
		// 再次，执行保持操作,保存的实例计划一条insert sql语句，注意只是计划，并不执行；
		session.save(author);

		// 最后，提交事务，关闭资源
	}
	
	@Test
	public void testUpdate() {
		// 更新数据
		
		// 获取数据
		Author author = (Author) session.get(Author.class, 84);
		
		// 更新数值
		author.setBirth(new GregorianCalendar(1990, 2, 32).getTime());
		
		// 提交更新
		session.save(author);
	}
	
	@Test
	public void testSaveOrUpdate() {
		// 保存，或者更新。根据实体类的情况决定是要保存还是更新操作。
	}
	
	@Test
	public void testDelete() {
		// 删除数据
		Author author =  (Author) session.get(Author.class, 82);
		session.delete(author);
	}

	
	@Test
	public void testObjectStatus() {
		// hibernate 中对象状态的转变
		
		Author author = (Author) session.get(Author.class, 84);
		session.evict(author);

		transaction.commit();
		session.close();

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		author.setName("caoxueqin");
		session.update(author);
	}
	
	@Test
	public void testQuery() {
		// 查询数据，返回结果多条
		List<Author> li =session.createQuery("from Author").list();
		for (Author a : li) {
			System.out.println(a);
		}
	}

}
