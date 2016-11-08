package s126.hello.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;
import org.junit.Test;

import s126.hello.dao.BaseDao;

/**
 * 数据库连接关闭的辅助类
 * @author Administrator
 */
public class DBUtil {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static {
		try {

			// 从 db.properties 加载配置文件
			Properties prop = new Properties();
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(
					"db.properties");
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeAll(ResultSet rs, Statement ps, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据resource指定路径获取sessionFactory对象
	 * @param
	 * @return 返回SessionFactory对象或者null
	 * */
	private static SessionFactory sessionFactory;
	private static Configuration configuration ;
	//TODO 这里还没写完，没有考虑并发，session属性不应为static
	private static Session session;
	private static Logger log = Logger.getLogger(BaseDao.class);
	@SuppressWarnings("deprecation")
	
	public static SessionFactory getSessionFactory(){
		try{
		   return new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			log.info(e);
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 获取session对象
	 * 默认加载hibernate.cfg.xml
	 * */
	public static Session getSession(){
		try{	
			configuration = new Configuration().configure();
			ServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(build);
			session = sessionFactory.openSession();
		}catch(Exception e){
//			log.info(e);
			e.printStackTrace();
			return null;
		}
		return session;
	}
	
	public static Session getSession(String resource){
		try{	
			configuration = new Configuration().configure(resource);
			ServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(build);
			session = sessionFactory.openSession();
		}catch(HibernateException h){
//			log.info("找不到资源文件");
			h.printStackTrace();
		}catch(Exception e){
//			log.info(e);
			e.printStackTrace();
			return null;
		}	
		return session;
	}
	
	@Test
	public void testGetSession(){
		DBUtil.getSession("test.main.hibernate.cfg.xml");
	}
}
