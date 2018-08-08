package PostgressTesting.Hibernate;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class RetrieveData {
	
	static Session s;
	
	public static void main(String[] args) {
		s=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory()
				.openSession();
		try {
			Employee e1;
			s.beginTransaction();
			//s.get(Tipo de objeto , id)
			e1=s.get(Employee.class, 2);
			System.out.println("|"+e1.getId()+
					"|"+e1.getFirstName()+
					"|"+e1.getLastName());
			System.out.println(e1);
			//s.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();
		}
		System.out.println("successfully saved");  
	}

}
