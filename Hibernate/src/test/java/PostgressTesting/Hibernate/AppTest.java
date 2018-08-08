package PostgressTesting.Hibernate;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest{
	List <Employee> lista;
	HibernateMainDB h=new HibernateMainDB();
	static Session s;

	@BeforeClass
	public static void init() {
		s=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory()
				.openSession();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void storeTest() {
		h.insert("zzz","ZZZ");
		h.retrive();
		try {
			lista=new LinkedList<Employee>();
			lista=s.createQuery("from Employee").getResultList();//Retrieves the Table on a List
			for (Employee temp: lista) {//Iterates over the retrieved List
				if (temp.getFirstName().equals("zzz")) {
					s.beginTransaction();
					s.delete(temp);//Deletes the element
					s.getTransaction().commit();//Execute
					break;
				}
			}
			h.retrive();
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}
	}

	@SuppressWarnings("unchecked")
	@Before
	public void seekTest() {
		try {
			//h.CreateSession();
			lista=new LinkedList<Employee>();
			lista=s.createQuery("from Employee").getResultList();//Retrieves the Table on a List
			for (Employee temp: lista) {//Iterates over the retrieved List
				if (temp.getFirstName().equals("ooo")) {
					System.out.println(temp);
					break;
				}//Prints each element
			}
		} catch (Exception e) {
			System.out.println("Error="+e);
		}
	}

	@After
	public void closing() {
		s.close();
	}

}