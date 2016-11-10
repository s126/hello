package hibernate.guanlian;


public class Book {
	private Integer bid;
	private String bookName;
	private String bookPrice;
	private Author author;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Book(String bookName, String bookPrice, Author author) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.author = author;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bookName=" + bookName + ", bookPrice="
				+ bookPrice + ", author=" + author + "]";
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Book(String bookName, String bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
}
