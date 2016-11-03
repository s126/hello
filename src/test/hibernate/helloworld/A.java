package hibernate.helloworld;

import hibernate.BaseTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;


/**
 * hibernate 的基本语法，简单使用
 */

public class A extends BaseTest {

	@Test
	public void testSave() throws ParseException {
		// save 保存一条数据
		Author author = new Author();
		author.setName("李白");
		author.setBirth(new SimpleDateFormat("yyyyMMdd").parse("10000101"));
		
		session.save(author);
	}
	
	@Test
	public void testGet() {
		// 根据主键，查询数据。单条返回结果
		Author author = (Author) session.get(Author.class, 3);
		System.out.println(author);
	}
	
	@Test
	public void testLoad() {
		// 根据主键，查询数据。单条返回结果
		
		// get 跟 load 的区别如下：
		// 1. 如果查询的数据不存在的话，那么 get 会返回 null，而 load 会抛出异常。
		// 2. get 是立即从数据库中检索数据； load 是懒加载，即只有当要使用对象的时刻，才进行加载，懒加载是通过代理实现的。
		// 3. get 会直接连接数据库查询； load 会首先尝试从缓存中获取数据。
		Author author = (Author) session.load(Author.class, 3);
		System.out.println(author);
	}
	
	@Test
	public void testUpdate() {
		// 更新数据
	}
	
	@Test
	public void testSaveOrUpdate() {
		// 保存，或者更新。根据实体类的情况决定是要保存还是更新操作。
	}
	
	@Test
	public void testDelete() {
		// 删除数据
	}

	@Test
	public void testFlush() {
		// 更新缓存
	}
	
	@Test
	public void testRefresh() {
		// 更新缓存
	}
	
	@Test
	public void testClear() {
		// 清理缓存
	}
	
	@Test
	public void testEvid() {
		// 清理缓存
	}
	
	@Test
	public void testQuery() {
		// 查询数据，返回结果多条
	}

}
