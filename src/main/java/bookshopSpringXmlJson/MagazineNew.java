package bookshopSpringXmlJson;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="MAGAZINE")
public class MagazineNew extends LiteratureNew {
	
	public MagazineNew() {
		
	}

	public MagazineNew(String title, String publisher, int year, int numbersPerYear) {
		super(title, publisher, year, numbersPerYear);
	}
	
	@Override
	public String toString() {
		return "Magazine [publisher=" + getPublisher() + ", title=" + getTitle() + ", year=" + getYear() + ", numbersPerYear="
				+ getNumbersPerYear() + "]";
	}

}
