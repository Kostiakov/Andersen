package bookshopSpringXml;

import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class BookShop {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context
				.getBean("jdbcTemplate");
		
		List booksAndMagazines = jdbcTemplate.query("SELECT * FROM literature", new LiteratureMapper());
		System.out.println(booksAndMagazines);
		 
		 while(true) {
				System.out.println("¬ведите 1 дл€ вывода всей литературы, 2 дл€ добавлени€ новой, 3 дл€ записи в файл, 4 дл€ выхода из программы");
				Scanner scanner = new Scanner(System.in);
				int i = scanner.nextInt();
				if(i==1) {
					System.out.println(booksAndMagazines);
				}
				if(i==2) {
					System.out.println("¬ведите тип литературы: 1 - книга, 2 - журнал");
					int j = scanner.nextInt();
					LiteratureNew litera = null;
					if(j==1) {
						System.out.println("¬ведите следующие данные через Enter");
						System.out.println("јвтор, название, издатель, год");
						String author = scanner.next();
						String title = scanner.next();
						String publisher = scanner.next();
						String type = "BOOK";
						int year = scanner.nextInt();
						litera = new BookNew(author, title, publisher, year);
						booksAndMagazines.add(litera);
						String sql="INSERT INTO bookshop.literature(author, title, publisher, year, type) "
								+ "VALUES (\'" + author + "\', \'" + title + "\', \'" + publisher + "\', \'" + year + "\', \'" + type + "\');";
						jdbcTemplate.update(sql);
					}
					if(j==2) {
						System.out.println("¬ведите следующие данные через Enter");
						System.out.println("»здательство, название, год, количество номеров в год");
						String publisher = scanner.next();
						String title = scanner.next();
						int year = scanner.nextInt();
						int numbersPerYear = scanner.nextInt();
						String type = "MAGAZINE";
						litera = new MagazineNew(title, publisher, year, numbersPerYear);
						booksAndMagazines.add(litera);
						String sql="INSERT INTO bookshop.literature(publisher, title, year, numbers_per_year, type) "
								+ "VALUES (\'" + publisher + "\', \'" + title + "\', \'" + year + "\', \'" + numbersPerYear + "\', \'" + type + "\');";
						jdbcTemplate.update(sql);
					}
				}
				if(i==3) {
					JAXBContext jaxbContext=null;
					Marshaller marshaller=null;
					ListClass newList=new ListClass(booksAndMagazines);
					try {
						jaxbContext = JAXBContext.newInstance(ListClass.class);
						marshaller = jaxbContext.createMarshaller();
						marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
						marshaller.marshal(newList, new File("literature.xml"));
					} catch (JAXBException e) {
						e.printStackTrace();
					}
				}
				if(i==4) {
					break;
				}
			}
		 
	}	 
}
