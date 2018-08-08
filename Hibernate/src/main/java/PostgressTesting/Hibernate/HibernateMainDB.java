package PostgressTesting.Hibernate;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateMainDB {
	static Scanner scanf=new Scanner(System.in);
	List<Employee> lista;
	static Session s;

	/************************* S E S S I O N  *******************************/
	public void CreateSession() {
		s=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory()
				.openSession();
	}

	/************************** I N S E R T *********************************/
	public void insert() {
		String firstName,lastName;
		try {
			this.CreateSession();
			//Capture the values
			System.out.println("Type First Name");
			firstName=scanf.next();
			scanf.reset();
			System.out.println("Type Last Name");
			lastName=scanf.next();
			scanf.reset();
			s.beginTransaction();//Begins the Session
			s.save(new Employee(0,firstName,lastName));//Get the values into the Session
			s.getTransaction().commit();//Execute
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();//Terminates the Session
		}
		System.out.println("successfully saved");
	}
	
	public void insert(String fname, String lname) {
		try {
			this.CreateSession();
			s.beginTransaction();//Begins the Session
			s.save(new Employee(0,fname,lname));//Get the values into the Session
			s.getTransaction().commit();//Execute
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();//Terminates the Session
		}
		System.out.println("successfully saved");
	}

	/************************** R E T R I E V E *******************************/
	@SuppressWarnings("unchecked")
	public void retrive() {
		try {
			this.CreateSession();
			s.beginTransaction();//Begins the Session
			lista=new LinkedList<Employee>();
			lista=s.createQuery("from Employee").getResultList();//Retrieves the Table on a List
			System.out.println("\nTable Employee Info\n");
			for (Employee temp: lista) {//Iterates over the retrieved List
				System.out.println(temp.toString());//Prints each element
			}
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();//Terminates the Session
		}
	}

	/**************************** S E E K ***********************************/
	public Employee seek(int id) {
		Employee temp=null;
		try {
			this.CreateSession();
			s.beginTransaction();//Begins the Session
			temp=s.get(Employee.class,id);//Seeks the ID
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();//Terminates the Session
		}
		return temp;//If the ID exist returns Employee info else returns null  
	}

	/************************** D E L E T E *******************************/
	public void delete(Employee temp) {		
		try {
			this.CreateSession();//Begins the Session
			s.beginTransaction();
			s.delete(temp);//Deletes the element
			s.getTransaction().commit();//Execute
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();//Terminates the Session
		}
	}

	/*************************** M O D I F Y *********************************/
	public void modify(Employee temp) {
		try {
			this.CreateSession();//Begins the Session
			s.beginTransaction();
			s.update(temp);//Modify the element
			s.getTransaction().commit();//Execute
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}finally {
			s.close();//Terminates the Session
		}
	}
	
	public void menu() {
		boolean exit=false;
		int op,id;
		String name;
		Employee emp=null;
		HibernateMainDB hmdb=new HibernateMainDB();
		try {
			//Initialize the Session for PGSQL Connection
			do {
				//Basic menu
				System.out.println("\nMenu");
				System.out.println("1.-Store\n2.-Retrive\n3.-Seek");
				System.out.println("4.-Modify\n5.-Delete\n6.-Exit");
				op=scanf.nextInt();
				scanf.reset();
				switch (op) {
					case 1://Store Data
						hmdb.insert();
						break;
					case 2://Retrieve All Data
						hmdb.retrive();
						break;
					case 3://Seek Data
						System.out.println("Type the ID to Retrieve");
						id=scanf.nextInt();
						emp=hmdb.seek(id);
						if (emp!=null) {//If ID is valid prints the info
							System.out.println("\nThe info is\n"+emp);
						} else {//Else prints error
							System.out.println("The ID does not Exist!");
						}
						break;
					case 4://Modify Data
						System.out.println("Type the ID to Modify");
						id=scanf.nextInt();
						scanf.reset();
						emp=hmdb.seek(id);//Seeks the ID
						if (emp!=null) {//If ID is valid prints the info


							System.out.println("\nThe next info will be Modify\n"
									+emp+"\n");

							System.out.println("\nSelect \n1.-First Name\n2.-Last Name");
							id=scanf.nextInt();
							scanf.reset();
							switch (id) {
								case 1:
									System.out.println("Write the new First Name");
									name=scanf.next();
									scanf.reset();
									emp.setFirstName(name);
									break;
								case 2:
									System.out.println("Write the new Last  Name");
									name=scanf.next();
									scanf.reset();
									emp.setLastName(name);
									break;
								default:
									break;
							}
							hmdb.modify(emp);
						} else {//Else prints error
							System.out.println("The ID does not Exist!");
						}
						break;
					case 5://Delete Data
						System.out.println("Type the ID to Delete");
						id=scanf.nextInt();
						emp=hmdb.seek(id);//Seeks the ID
						if (emp!=null) {//If ID is valid prints the info
							hmdb.delete(emp);
							System.out.println("\nThe next info will be Deleted\n"
									+emp+"\n");
						} else {//Else prints error
							System.out.println("The ID does not Exist!");
						}
						break;
					case 6:
						exit=true;
						break;

					default:
						System.out.println("Invalid Option, try again.");
						break;
				}
			} while (!exit);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("Bye");
			scanf.close();
			System.exit(0);
		}
	}

	/**************************** M A I N ***********************************/
	public static void main(String[] args) {
		//Before running the java program make sure Postgress is Running
		//check Employee DB pgsql.txt for small reference
		new HibernateMainDB().menu();
	}
}