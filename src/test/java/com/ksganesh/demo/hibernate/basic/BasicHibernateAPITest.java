/**
 * 
 */
package com.ksganesh.demo.hibernate.basic;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ksganesh.demo.hibernate.basic.model.Person;

import junit.framework.TestCase;

/**
 * @author ksganesh
 *
 */
public class BasicHibernateAPITest extends TestCase {

	private SessionFactory sessionFactory;
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy( registry );
		}
		
		
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@Test
	public void testBasicUsage() {
		//Create couple of Person
		
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Person("Neela", new Date(2016,10,6)));
		session.save(new Person("Magi", new Date(1972,8,15)));
		session.getTransaction().commit();
		session.close();
		
		
		// now lets pull events from the database and list them
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		List result=session1.createQuery("from Person").list();
		for ( Person person : (List<Person>) result ) {
			System.out.println( "Person (" + person.getName() + ") : " + person.getBirthDate() );
		}
		session1.getTransaction().commit();
		session1.close();
	}

}
