package Serializacion;
import java.io.Serializable;


public class Serializacion implements Serializable{
      private static final long serialVersionUID = 1L;
      private String nombre,apellido;
      
      public String getNombre() {
	      return nombre;
      }
	
	public String getApellido() {
	      return apellido;
      }

	public Serializacion(String nombre,String apellido) {
	      this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String toString(){
		return"[Nombre: "+nombre+"][Apellido: "+apellido+"]";
	}
}
