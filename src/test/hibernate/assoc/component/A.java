package hibernate.assoc.component;

import hibernate.BaseTest;

import org.junit.Test;

public class A extends BaseTest {
	public static void main(String[] args) {
		printddl();
	}
	
	@Test
	public void testComponent() {
		Address addr = new Address();
		addr.setCity("珠海");
		addr.setStreet("工业大道111号");
		
		Customer customer = new Customer();
		customer.setName("无名氏");
		customer.setAddr(addr);
		
		session.save(customer);
	}

}
