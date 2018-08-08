package PostgressTesting.Hibernate;


import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	
	static Session s;
	static List<Employee> lista;

	public static void main(String[] args) {
		s=new Configuration().configure(""
				+ "hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
		try {
			
			s.beginTransaction();
			lista=new LinkedList<Employee>();
			 lista=s.createQuery("from Employee").getResultList();

			for (Employee e1: lista) {
				if (e1.getId()==2) {
					s.delete(e1);
					s.getTransaction().commit();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();
		}
		System.out.println("successfully saved");  
	}
}