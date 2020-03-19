package bookshop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookShop {
	
	static final String url="jdbc:mysql://localhost:3306/bookshop?useSSL=false&serverTimezone=UTC";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		try(Connection connection=DriverManager.getConnection(url,"hbstudent","hbstudent")){
		
		System.out.println("Connection successed");
		
		String sql = "SELECT * FROM literature";
		
		Statement statement=connection.createStatement();
		
		ResultSet set = statement.executeQuery(sql);
		
		List<LiteratureNew> list = new ArrayList<>();
		
		 while (set.next()) {
	            String author = set.getString("author");
	            String title = set.getString("title");
	            String publisher = set.getString("publisher");
	            int year = set.getInt("year");
	            int numbers_per_year = set.getInt("numbers_per_year");
	            String type = set.getString("type");
	            System.out.println(author + title + publisher + year + type);
	            if(type.equals("BOOK")) {
	            	LiteratureNew book = new BookNew(author, title, publisher, year);
	            	list.add(book);
	            }
	            if(type.equals("MAGAZINE")) {
	            	LiteratureNew magazine = new MagazineNew(title, publisher, year, numbers_per_year);
	            	list.add(magazine);
	            }
		 }
		 System.out.println(list);
		 set.close();
		 statement.close();
		 
		 while(true) {
				System.out.println("¬ведите 1 дл€ вывода всей литературы, 2 дл€ добавлени€ новой, 3 дл€ выхода из программы");
				Scanner scanner = new Scanner(System.in);
				int i = scanner.nextInt();
				if(i==1) {
					System.out.println(list);
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
						list.add(litera);
						sql="INSERT INTO bookshop.literature(author, title, publisher, year, type) "
								+ "VALUES (\'" + author + "\', \'" + title + "\', \'" + publisher + "\', \'" + year + "\', \'" + type + "\');";
						statement = connection.createStatement();
						//statement.executeUpdate(sql);
						statement.close();
					}
					if(j==2) {
						System.out.println("¬ведите следующие данные через Enter");
						System.out.println("»здательство, название, год, количество номеров в год");
						String publisher = scanner.next();
						String title = scanner.next();
						int year = scanner.nextInt();
						int numbersPerYear = scanner.nextInt();
						String type = "MAGAZINE";
						litera = new MagazineNew(publisher, title, year, numbersPerYear);
						list.add(litera);
						sql="INSERT INTO bookshop.literature(publisher, title, year, numbers_per_year, type) "
								+ "VALUES (\'" + publisher + "\', \'" + title + "\', \'" + year + "\', \'" + numbersPerYear + "\', \'" + type + "\');";
						statement = connection.createStatement();
						//statement.executeUpdate(sql);
						statement.close();
					}
				}
				if(i==3) {
					break;
				}
				}
		}
		 
	}	 
}
