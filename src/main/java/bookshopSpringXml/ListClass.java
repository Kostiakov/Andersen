package bookshopSpringXml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(LiteratureNew.class)
public class ListClass {
	
	private List myList;
	
	public ListClass() {
		
	}
	
	public ListClass(List myList) {
		this.myList=myList;
	}

}
