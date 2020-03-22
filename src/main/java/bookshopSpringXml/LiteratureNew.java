package bookshopSpringXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({BookNew.class, MagazineNew.class})
public abstract class LiteratureNew {
	
	private String author;
	private String title;
	private String publisher;
	private Integer year;
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
	
	

}
