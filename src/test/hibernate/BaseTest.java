package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

	private static SessionFactory sessionFactory = null;
	private static Transaction transaction = null;
	public static Session session = null;

	@BeforeClass
	public static void init() {
		Configuration config = new Configuration().configure("/hibernate/helloworld/hello.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);

		// 处理业务的地
		// 首先要获取一个数据库连接，在 hibernate 中，是用 session 对象表示的这么个连接
		session = sessionFactory.openSession();

		// 事务处理
		transaction = session.beginTransaction();

	}
	
	@AfterClass
	public static void clean() {
		// 一定不要忘掉资源的关闭等
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
