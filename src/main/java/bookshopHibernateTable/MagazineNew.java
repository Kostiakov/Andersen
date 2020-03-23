package bookshopHibernateTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="magazineNew")
public class MagazineNew extends LiteratureNew {
	
	@Column(name="numbers_per_year")
	private Integer numbersPerYear;
	
	public Integer getNumbersPerYear() {
		return numbersPerYear;
	}

	public void setNumbersPerYear(Integer numbersPerYear) {
		this.numbersPerYear = numbersPerYear;
	}

	public MagazineNew() {
		
	}
	
	@Override
	public String toString() {
		return "Magazine [publisher=" + getPublisher() + ", title=" + getTitle() + ", year=" + getYear() + ", numbersPerYear="
				+ getNumbersPerYear() + "]";
	}

}
