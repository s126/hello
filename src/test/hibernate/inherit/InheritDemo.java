package hibernate.inherit;

import hibernate.BaseTest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.junit.Test;


public class InheritDemo extends BaseTest {
	public static void main(String[] args) {
		printddl();
	}
	
	@Test
	public void testSingleTable() {
		Person p = new Person();
		p.setAge(88);
		p.setName("流风");
		
		session.save(p);
		
		Girl girl = new Girl();
		girl.setName("小鱼");
		girl.setAge(18);
		girl.setBag("LVVVV");
		
		session.save(girl);
		
		Boy boy = new Boy();
		boy.setName("晓渔");
		boy.setGame("连连看");
		boy.setAge(14);
		
		session.save(boy);
	}
	
}

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
// @Inheritance(strategy=InheritanceType.JOINED)
class Person {
	
	@Id
	@GeneratedValue
	private int Id;
	
	private String name;
	private int age;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}


@Entity
class Girl extends Person {

	private String bag;

	public String getBag() {
		return bag;
	}

	public void setBag(String bag) {
		this.bag = bag;
	}
	
}

@Entity
class Boy extends Person {
	
	private String game;

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

}