package bookshop;

public class Book implements Literature {
	
	private String author;
	private String title;
	private String publisher;
	private int year;
	
	public Book() {
		
	}
	
	
	public Book(String author, String title, String publisher, int year) {
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.year = year;
	}


	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", publisher=" + publisher + ", year=" + year + "]";
	}
	

}
