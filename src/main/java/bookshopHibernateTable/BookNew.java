package bookshopHibernateTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bookNew")
public class BookNew extends LiteratureNew {
	
	@Column(name="author")
	private String author;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookNew() {
		
	}

	@Override
	public String toString() {
		return "Book [author=" + getAuthor() + ", title=" + getTitle() + ", publisher=" + getPublisher() + ", year=" + getYear() + "]";
	}

}
