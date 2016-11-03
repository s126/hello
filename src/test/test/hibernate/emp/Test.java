package test.hibernate.emp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import test.hibernate.helloworld.Book;


public class Test {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		/*Configuration configuration = new Configuration().configure("/test/hibernate/emp/hibernate.cfg.xml");
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(build);
		
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Emp e = new Emp(1, "a", 11, "s");
		session.save(e);
		beginTransaction.commit();
		List<Emp> list = session.createQuery("from emp1").list();
		for (Emp emp : list) {
			System.out.println(list);
		}*/
		
		
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();

		// 简单的插入
		Transaction transaction = session.beginTransaction();
		session.save(new Emp( "a", 11, "s"));
		
		// 简单的查询
		Query query = session.createQuery("from Emp");
		List<Book> booklist = query.list();
		
		
		System.out.println(booklist);

		transaction.commit();
		
		session.close();
		sessionFactory.close();
		
	}
	
	@org.junit.Test
	public void test(){
		System.out.println(1);
	}
}
