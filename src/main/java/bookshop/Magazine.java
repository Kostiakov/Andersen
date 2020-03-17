package bookshop;

public class Magazine implements Literature {
	
	private String publisher;
	private String title;
	private int year;
	private int numbersPerYear;
	
	public Magazine() {
		
	}

	public Magazine(String publisher, String title, int year, int numbersPerYear) {
		this.publisher = publisher;
		this.title = title;
		this.year = year;
		this.numbersPerYear = numbersPerYear;
	}

	@Override
	public String toString() {
		return "Magazine [publisher=" + publisher + ", title=" + title + ", year=" + year + ", numbersPerYear="
				+ numbersPerYear + "]";
	}
	

}
