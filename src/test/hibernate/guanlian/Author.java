package hibernate.guanlian;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Author {
	private Integer aid;
	private String name;
	private Date birth;
	private Set<Book> books = new HashSet<Book>();
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
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

	
	public Author() {
		super();
	}
	public Author(String name, Date birth) {
		super();
		this.name = name;
		this.birth = birth;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Author(String name, Date birth, Set<Book> books) {
		super();
		this.name = name;
		this.birth = birth;
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [aid=" + aid + ", name=" + name + ", birth=" + birth
				+ ", books=" + books + "]";
	}
	
	
	
	
}
