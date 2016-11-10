package hibernate.helloworld;

import hibernate.BaseTest;

import java.util.Date;
import java.util.List;

import org.junit.Test;


public class B extends BaseTest {
	
	@Test
	public void testEntity() {
		Author author = new Author();
		author.setName("huangdongying");
		author.setBirth(new Date());
		
		Book oracle = new Book("Oracle", 99.0f);
		oracle.setAuthor(author);
		
		session.save(oracle);
	}
	
	@SuppressWarnings("unchecked")
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
}
