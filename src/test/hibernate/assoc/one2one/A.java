package hibernate.assoc.one2one;

import hibernate.BaseTest;

import java.util.GregorianCalendar;

import org.junit.Test;

public class A extends BaseTest {
	public static void main(String[] args) {
		printddl();
	}
	
	@Test
	public void testSave() {
		Master m = new Master();
		m.setName("zengfm");
		m.setBirth(new GregorianCalendar(1976, 2, 2).getTime());
		
		School s = new School();
		s.setName("southit");
		s.setAddr("doumenqu");
		
		s.setMaster(m);
		m.setSchool(s);
		
		session.save(s);
		session.save(m);
	}
	
}
