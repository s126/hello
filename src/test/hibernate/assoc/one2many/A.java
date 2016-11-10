package hibernate.assoc.one2many;

import java.util.Iterator;
import java.util.Set;

import hibernate.BaseTest;

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
//		session.save(oracle);
//		session.save(hibernate);
		
		Author author = new Author();
		author.setName("五月末");
		
		author.getBooks().add(oracle);
		author.getBooks().add(hibernate);
		
		session.save(author);
		
		System.out.println("hello");
	}
	
	@Test
	public void testO2MGet () {
		Author author = (Author) session.get(Author.class, 1);
		System.out.println(author);
		
		Book demobook = new Book("aaa", 222f);
		
		Set<Book> books = author.getBooks();
		
		// 如果设置了 fetch 策略为 extra 的话，那么，下面三句并不会触发初始化列表的动作
		System.out.println(books.isEmpty());
		System.out.println(books.size());
		System.out.println(books.contains(demobook));
		
		Iterator<Book> it = books.iterator();
		while(it.hasNext()) {
			Book b = (Book)it.next();
			System.out.println(b.getName());
		}
	}
	
	
	
	@Test
	public void testMakeData () {
		Book book1 = new Book("js", 22f);
		Book book2 = new Book("html", 23f);
		
		Book book3 = new Book("jquery", 26f);
		Book book4 = new Book("spring", 27f);
		Book book5 = new Book("summer", 28f);
		Book book6 = new Book("winter", 29f);
		Book book7 = new Book("autumn", 30f);
		
		// session.save(book1);
		
		Author author1 = new Author();
		author1.setName("xiaohua");
		
		Author author2 = new Author();
		author2.setName("liufeng");
		
		author1.getBooks().add(book1);
		author1.getBooks().add(book2);

		author2.getBooks().add(book3);
		author2.getBooks().add(book4);
		author2.getBooks().add(book5);
		author2.getBooks().add(book6);
		author2.getBooks().add(book7);
		
		session.save(author1);
		session.save(author2);
		
	}
	
	@Test
	public void testSubselect () {
		session.createQuery("from Author").list();
	}
	
}







