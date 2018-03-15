package Serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerializacionStrings implements Serializable{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		String nombre,apelido;
		try {
			//Mete las cadenas en el archivo
			FileOutputStream fos=new FileOutputStream("ObjectString.txt");
			ObjectOutput obj=new ObjectOutputStream(fos);
			obj.writeObject("Jose");
			obj.writeObject("Galarza");
			obj.flush();
			obj.close();
			System.out.println("Si charcho sin mandar NoCharchaException");
			//Saca las cadenas del archivo
			FileInputStream abrir=new FileInputStream("ObjectString.txt");
			ObjectInputStream misDatos=new ObjectInputStream(abrir);
			nombre=(String)misDatos.readObject();
			apelido=(String)misDatos.readObject();
			System.out.println("El Nombre es: "+nombre+"\ny el Apellido es: "+apelido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
