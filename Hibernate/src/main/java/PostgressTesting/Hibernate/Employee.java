package PostgressTesting.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idemp")
	private int id;
	@Column(name="nombre")
	private String firstName;
	@Column(name="apellido")
	private String lastName;  

	public Employee() {
		// Puto el que lo borre.
	}

	public Employee(int id,String firstName, String lastName) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public int getId() {  return id;  }  
	public void setId(int id) {  this.id = id;  }  
	public String getFirstName() {  return firstName;  }  
	public void setFirstName(String firstName) {  this.firstName = firstName;  }  
	public String getLastName() {  return lastName; }  
	public void setLastName(String lastName) {  this.lastName = lastName;  }
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}  
}