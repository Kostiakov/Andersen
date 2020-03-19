package bookshopHibernate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="literature")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class LiteratureNew {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="author")
	private String author;
	@Column(name="title")
	private String title;
	@Column(name="publisher")
	private String publisher;
	@Column(name="year")
	private Integer year;
	@Column(name="numbers_per_year")
	private Integer numbersPerYear;
	
	public LiteratureNew() {
		
	}
	
	public LiteratureNew(String author, String title, String publisher, int year) {
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.year = year;
	}

	public LiteratureNew(String title, String publisher, int year, int numbersPerYear) {
		this.title = title;
		this.publisher = publisher;
		this.year = year;
		this.numbersPerYear = numbersPerYear;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYear() {
		return year;
	}

	public int getNumbersPerYear() {
		return numbersPerYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setNumbersPerYear(int numbersPerYear) {
		this.numbersPerYear = numbersPerYear;
	}
	

}
