package hibernate.assoc.one2many;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Integer bookno;
	
	@Basic
	@Column
	private String name;
	private Float price;
	
	public Book() {
		super();
	}

	public Book(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Integer getBookno() {
		return bookno;
	}

	public void setBookno(Integer bookno) {
		this.bookno = bookno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}

}
