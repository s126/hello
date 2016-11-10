package hibernate.assoc.many2oneBW;

import hibernate.BaseTest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;


public class A extends BaseTest {
	
	public static void main(String[] args) {
		printddl();
	}

	@Test
	public void testOne2Many() {
		
		Book oracle = new Book("Oracle11g", 22f);
		Book hibernate = new Book("Hibernate4", 35f);
		
		// 在下面保存作者之前，需要先将下面两条数据进行持久化
		// 当然，也可以设置级联属性(cascade)，那么在下面进行保存的时候，会自动对没有持久化的对象持久化
		
		Author author = new Author();
		author.setName("五月末");
		
		
		author.getBooks().add(oracle);
		author.getBooks().add(hibernate);
		oracle.setAuthor(author);
		hibernate.setAuthor(author);
		
		session.save(oracle);
		session.save(oracle);
		session.save(hibernate);
		
		
		System.out.println("hello");
	}
	
	
	@Test
	public void testSave() {
		Author author = new Author();
		author.setName("艾莉森sss");
		author.setBirth(new Date());
		


		Book oracle = new Book("Oracle222", 998f);
		Book mysql = new Book("MySQL333", 228f);
		oracle.setAuthor(author);
		mysql.setAuthor(author);
		
		
		author.getBooks().add(oracle);
		author.getBooks().add(mysql);
		
		
		// 注意，要先保存 1 的一方，这样会产生 3 条 insert 语句
		// 如果先保存的是 n 的一方，将会产生 3 条 insert 语句和 2 条 update 语句，产生了不必要的冗余。
		session.save(author);

		session.save(oracle);
		session.save(mysql);
		
	}
	
	
	@Test
	public void testGet() {
//		Book oracle = (Book) session.get(Book.class, 2);
//		System.out.println(oracle.getAuthor());
		
		Author author = (Author) session.get(Author.class, 1);
		System.out.println(author.getBooks());
		
		
	}
	@Test
	public void testRemove() {

//		Book oracle = (Book) session.get(Book.class, 2);
//		oracle.setAuthor(null);
		
		Author author = (Author) session.get(Author.class, 1);
		author.getBooks().clear();
		
	}
	
	@Test
	public void testDelect() {
//		Book oracle = (Book) session.get(Book.class, 5);
//		session.delete(oracle);
		
		Author author = (Author) session.get(Author.class, 4);
		session.delete(author);
		
	}
	
}







