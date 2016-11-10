package test.main;

import java.util.Date;
import java.util.List;

import javax.persistence.Version;

import hibernate.guanlian.Author;
import hibernate.guanlian.Book;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import s126.hello.util.DBUtil;

public class TestOfguanlian {
	

	public void printddl(){
		DBUtil.printddl();
	}
	
	@Test
	public void saveBook(){
		Session session = null;
		Transaction transaction = null;
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			
//			Author author = (Author) session.get(Author.class, 1);
			
			Author author = new Author("perl", new Date());
//			session.save(author);
			
			Book book = new Book("cres", "11", author);
			
//			session.save(book);
			session.save(book);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@Test
	public void saveAuthor(){
		Session session = null;
		Transaction transaction = null;
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
			Book b1 = new Book("Oracle", "11");
			Author au = new Author("a", new Date());
			au.getBooks().add(b1);
			session.save(au);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	
	@Test
	public void Query(){
		Session session = null;
		Transaction transaction = null;
		try{
			session = DBUtil.getSession();
			transaction = session.beginTransaction();
//			session.get(Book.class, 82);
			List<Author> authors = session.createQuery("from Author").list();
			
			System.out.println(authors.isEmpty());
//			System.out.println(books);
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
