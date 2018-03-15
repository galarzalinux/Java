package Serializacion;

import java.io.*;

public class TestSerializacionObjetos implements Serializable{
      private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Serializacion s=new Serializacion("Jose", "Galarza");
		try {
			//Mete el objeto en el archivo
			FileOutputStream fos=new FileOutputStream("Objeto.txt");
			ObjectOutput obj=new ObjectOutputStream(fos);
			obj.writeObject(s);
			obj.flush();
			obj.close();
			System.out.println("Si charcho sin mandar NoCharchaException");
			//Saca el objeto en el archivo
			FileInputStream abrir=new FileInputStream("Objeto.txt");
			ObjectInputStream misDatos=new ObjectInputStream(abrir);
			Serializacion s1=(Serializacion)misDatos.readObject();
			System.out.println(s1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
