package hibernate.assoc.many2one;

import hibernate.BaseTest;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Test;


public class A extends BaseTest {
	
	@Test
	public void testEntity() {
		Author author = new Author();
		author.setName("艾莉森");
		author.setBirth(new Date());
		
		//session.save(author);

		Book oracle = new Book("Oracle11g专家教程", 998f);
		oracle.setAuthor(author);
		session.save(oracle);
	}
	
	@Test
	public void lazy(){
		Book book = (Book) session.get(Book.class, 8);
//		session.load(Book.class, 6);
		//System.out.println(book.getName());
		transaction.commit();
		session.close();
		System.out.println(book.getAuthor().getName());
		
	}
	
	@Test
	public void testMany2OneLazy () {
		Book book1 = (Book) session.get(Book.class, 2);
		// lazy, need.
		System.out.println(book1.getAuthor().getAge());
		
	}
	
	@Test
	public void testMany2OneEager () {
//		testOneMany();
		
		Book book = (Book) session.get(Book.class, 2);
//		Hibernate.initialize(book.getAuthor());
		System.out.println(book.getAuthor().getAge());
	}
	
	@Test
	public void test2(){
		Author author = new Author();
		author.setName("zz");
		author.setBirth(new Date());
		
		Book book = new Book();
		book.setAuthor(author);
		book.setPrice(100f);
		book.setName("javasdf");
		//session.save(author);
		//session.save(book);
		
		//List<Book> li = session.getNamedQuery("abc").setParameter("name", "java2").list();
		List<Book> li =session.createQuery("from Book where name='javasdf'").list();
		Book books = (Book) session.load(Book.class, 12);
		//System.out.println(books.getAuthor());
		System.out.println(books.getAuthor());
		System.out.println(li.get(0).getAuthor());
		/*for (Book b : li) {
			System.out.println(b);
		}*/
		
				
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







