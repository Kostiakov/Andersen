import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bookshopHibernate.BookNew;
import bookshopHibernate.LiteratureNew;
import bookshopHibernate.MagazineNew;

public class HibernateTest {
	
	private List<LiteratureNew> listNew;
	
	private SessionFactory factory;
	private Session session;
	private Transaction tr;
	private int number;
	
	@Before
	public void init() {
				factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(LiteratureNew.class).
				addAnnotatedClass(BookNew.class).
				addAnnotatedClass(MagazineNew.class).
				buildSessionFactory();
				session = factory.getCurrentSession();
				tr = session.beginTransaction();
				number=11;
	}
	
	@After
	public void finalize() {
		tr.rollback();
		factory.close();
	}
	
	@Test
	public void testGetList() {
		listNew=session.createQuery("from LiteratureNew").list();
		System.out.println(listNew);
		assertEquals(number,listNew.size());
	}
	
	@Test
	public void testAdd() {
		LiteratureNew litera = new BookNew("TestAuthor", "TestTitle", "TestPublisher", 2020);
		session.save(litera);
		listNew=session.createQuery("from LiteratureNew").list();
		System.out.println(listNew);
		assertEquals(number+1,listNew.size());
	}
	
	@Test
	public void testDelete() {
		LiteratureNew litera = session.get(LiteratureNew.class, 1);
		session.delete(litera);
		listNew=session.createQuery("from LiteratureNew").list();
		System.out.println(listNew);
		assertEquals(number-1,listNew.size());
	}

}
