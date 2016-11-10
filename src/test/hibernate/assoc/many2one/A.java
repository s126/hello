package hibernate.assoc.many2one;

import hibernate.BaseTest;

import java.util.Date;

import org.junit.Test;


public class A extends BaseTest {
	
	@Test
	public void testEntity() {
		Author author = new Author();
		author.setName("艾莉森");
		author.setBirth(new Date());
		
		// 如果不设置 cascade 的话，那么需要在保存下面的 oracle 之前，手动对 author 对象进行持久化操作。
		// 如果设置了 cascade，那么，这一步就没有必要了。
		session.save(author);

		Book oracle = new Book("Oracle11g专家教程", 998f);
		oracle.setAuthor(author);
		session.save(oracle);
	}
	
	@Test
	public void testLazy(){
		Book book = (Book) session.get(Book.class, 8);
//		session.load(Book.class, 6);
		System.out.println(book.getAuthor().getName());
	}
	
	
	@Test
	public void testMany2OneEager () {
		Book book = (Book) session.get(Book.class, 2);
		book.getAuthor().sayHello();
//		Hibernate.initialize(book.getAuthor());
		System.out.println(book.getAuthor().getAge());
	}
	
	
	
	
	

	
	
	
	@Test
	public void testOneMany() {
		
		Author author = new Author();
		author.setName("huangdongying");
		author.setBirth(new Date());
		
		session.save(author);
		

		Book oracle = new Book("Oracle", 99.0f);
		Book struts = new Book("Struts", 89f);
		
		oracle.setAuthor(author);
		struts.setAuthor(author);
		
		session.save(oracle);
		session.save(struts);
		
	}
	
	public static void main(String[] args) {
		printddl();
	}
	
	
}



