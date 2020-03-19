package bookshopHibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class BookNew extends LiteratureNew {
	
	public BookNew() {
		
	}
	
	public BookNew(String author, String title, String publisher, int year) {
		super(author, title, publisher, year);
	}

	@Override
	public String toString() {
		return "Book [author=" + getAuthor() + ", title=" + getTitle() + ", publisher=" + getPublisher() + ", year=" + getYear() + "]";
	}

}
