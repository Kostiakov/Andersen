package bookshopHibernateTable;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class BookShop {
	
	static final String url="jdbc:mysql://localhost:3306/bookshop?useSSL=false&serverTimezone=UTC";

	/*public static List<LiteratureNew> getLiterature(Session session){
		session.beginTransaction();
		List<LiteratureNew> listNew=session.createQuery("from LiteratureNew").list();
		session.getTransaction().commit();
		return listNew;
	}*/
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		try(SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(LiteratureNew.class).
				addAnnotatedClass(BookNew.class).
				addAnnotatedClass(MagazineNew.class).
				buildSessionFactory()){
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		//List<LiteratureNew> listNew=null;
		
		List<LiteratureNew> listNew=session.createQuery("from LiteratureNew").list();
		
		//List<LiteratureNew> listNew=getLiterature(session);
		
		session.getTransaction().commit();
		
		 
			while (true) {
				System.out.println(
						"������� 1 ��� ������ ���� ����������, 2 ��� ���������� �����, 3 ��� ������ �� ���������");
				Scanner scanner = new Scanner(System.in);
				int i = scanner.nextInt();
				if (i == 1) {
					System.out.println(listNew);
				}
				if (i == 2) {
					System.out.println("������� ��� ����������: 1 - �����, 2 - ������");
					int j = scanner.nextInt();
					if (j == 1) {
						System.out.println("������� ��������� ������ ����� Enter");
						System.out.println("�����, ��������, ������������, ���");
						String author = scanner.next();
						String title = scanner.next();
						String publisher = scanner.next();
						int year = scanner.nextInt();
						BookNew bookNew = new BookNew();
						bookNew.setAuthor(author);
						bookNew.setPublisher(publisher);
						bookNew.setTitle(title);
						bookNew.setYear(year);
						listNew.add(bookNew);
						Session session2 = factory.getCurrentSession();
						session2.beginTransaction();
						session2.save(bookNew);
						session2.getTransaction().commit();
					}
					if (j == 2) {
						System.out.println("������� ��������� ������ ����� Enter");
						System.out.println("��������, ������������, ���, ���������� ������� � ���");
						String title = scanner.next();
						String publisher = scanner.next();
						int year = scanner.nextInt();
						int numbersPerYear = scanner.nextInt();
						MagazineNew magazineNew = new MagazineNew();
						magazineNew.setNumbersPerYear(numbersPerYear);
						magazineNew.setPublisher(publisher);
						magazineNew.setTitle(title);
						magazineNew.setYear(year);
						listNew.add(magazineNew);
						Session session2 = factory.getCurrentSession();
						session2.beginTransaction();
						session2.save(magazineNew);
						session2.getTransaction().commit();
					}
				}
				if (i == 3) {
					break;
				}
			}
		}
	}
}
