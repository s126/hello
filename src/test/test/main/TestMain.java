package test.main;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import s126.hello.bean.Account;

public class TestMain {
	public static void main(String[] args) throws ClassNotFoundException {
		@SuppressWarnings("rawtypes")
		Class acc = new Account().getClass();
		Cat annotations = (Cat) acc.getAnnotation(Cat.class);
		System.out.println(annotations.value());
//		for (Annotation annotation : annotations) {
//			System.out.println(((Cat)annotation).value());
//			System.out.println(annotation.annotationType());
//		}
	}
	
	@Test
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
}
