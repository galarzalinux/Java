package PostgressTesting.Hibernate;

import org.hibernate.Session;  
import org.hibernate.cfg.Configuration;  

public class StoreData {  
	static Session s;

	public static void main(String[] args) {  

		s=new Configuration().configure(""
				+ "hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory().openSession();
		try {
			Employee e1=new Employee(0,"francisco","diaz"); 
			s.beginTransaction();
			s.save(e1);
			s.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();
		}
		System.out.println("successfully saved");  
	}  
}  
