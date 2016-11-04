package test.main;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.junit.Test;

import s126.hello.bean.Account;
import s126.hello.util.DBUtil;

public class TestMain {
	
	private static Logger log = Logger.getLogger(TestMain.class);
//	public static void main(String[] args) throws ClassNotFoundException {
//		@SuppressWarnings("rawtypes")
//		Class acc = new Account().getClass();
//		Cat annotations = (Cat) acc.getAnnotation(Cat.class);
//		System.out.println(annotations.value());
////		for (Annotation annotation : annotations) {
////			System.out.println(((Cat)annotation).value());
////			System.out.println(annotation.annotationType());
////		}
//	}
	
	public void CalTest() throws ParseException{
		SimpleDateFormat simple = new SimpleDateFormat("YYYY/MM/dd");
		
		Calendar cal = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar(2000, 1, 1);
		Calendar cal3 = Calendar.getInstance();
		
		
		System.out.println("cal.MONTH:"+cal.get(cal.MONTH));
		
		Date date = new Date();
		Date date2 = simple.parse("2000/11/3");
		
		
		System.out.println("date.getTime()-date2.getTime():"+(date.getTime()-date2.getTime()));
		
		System.out.println("cal.getTime():"+cal.getTime().getTime()+"\ndate.getTime():"+date.getTime());
		
		System.out.println(simple.format(cal.getTime())+"\n"+simple.format(date));
		
		System.out.println(cal.compareTo(cal2)+"***"+cal2.compareTo(cal));
		
		System.out.println(cal);
		System.out.println(cal2);
		Date time = cal.getTime();
		System.out.println(simple.format(time));
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] a){
		Session session = DBUtil.getSession();
		Account acc = new Account("b" , "b", 1, null, null, null, null, null);
		Transaction beginTransaction = session.beginTransaction();
		session.save(acc);
log.info("asdasdasdasd1"+session.getEntityName(acc));

		
//		String acc_1 = session.getEntityName(acc);
//		log.debug("输出acc_1:"+acc_1);
		log.info("===");
		Account acc1 = (Account) session.get(Account.class, 1);
//		session.flush();
log.info("asdasdasdasdasd2"+session.getEntityName(acc));
session.save(new Account("d" , "b", 1, null, null, null, null, null));
		session.createQuery("from Account").list();
		log.info("===");
		beginTransaction.commit();
log.info("asdasdasdasdasd3"+session.getEntityName(acc));
	}
	
	@Test
	public void test1(){
		Session session = DBUtil.getSession();
		Account acc = (Account) session.get(Account.class, 42);
		acc.setAcctype(1);
		session.update(acc);
		session.flush();
		session.beginTransaction().commit();
	}
}
