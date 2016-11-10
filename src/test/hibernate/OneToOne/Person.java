package hibernate.OneToOne;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author D.O
 * @version 创建时间：2016年11月10日 下午2:45:43
 * 简单说明
 */
@Entity
public class Person {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Date birth;
	@OneToOne
	private PersonId personId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birth=" + birth + "]";
	}
	public Person() {
		super();
	}
	public Person(String name, Date birth) {
		super();
		this.name = name;
		this.birth = birth;
	}
	public PersonId getPersonId() {
		return personId;
	}
	public void setPersonId(PersonId personId) {
		this.personId = personId;
	}
}
