package hibernate.assoc.one2many;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import s126.hello.util.CommonUtil;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private int aid;
	private String name;
	private Date birth;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="authorid")
	private Set<Book> books = new HashSet<Book>();
	
	@Transient
	private int age;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	// 在 getter 方法中，可以写一些具体的逻辑。
	// 这里通过生日的字段，计算年龄。当调用这个 getter 方法的时候，才开始计算。
	// 而年龄这个值，不需要保存到数据库中。所以上面需要增加一个 @Transient 注解，将其排出在外。
	// 这种处理方式，是非常常见的。尤其在 getter/setter 方法中，添加自己的逻辑，有时候，会使代码变得便捷。
	public int getAge() {
		return age == 0 ? CommonUtil.calAge(birth) : age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void sayHello() {
		System.out.println("hello, s126");
	}
	
	@Override
	public String toString() {
		return "Author [aid=" + aid + ", name=" + name + ", birth=" + birth;
	}


}
