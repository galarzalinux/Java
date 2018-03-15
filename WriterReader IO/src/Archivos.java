import java.io.*;

public final class Archivos {
	private String nombreArc;

	public Archivos(String n) {
		nombreArc=n;
	}

	public static boolean existeArchivo(File f){//Valida si el archivo existe.
		if(f.exists()){
			return true;
		}else
			return false;
	}
	
	public static String archivoDelObjetoActual(File f){//Devuelve el nombre del archivo del objeto actual..
		return f.getName();		
	}
	
	public static boolean manipularArchivo(File f){//Comprueba si se puede leer y escribir el archivo.
		if(f.canRead()&&f.canWrite()){
			return true;
		}else{
			return false;
		}
	}

	public static void restringeArchivo(File f){
		if(manipularArchivo(f)){
			f.setReadable(false);
			f.setWritable(false);
			System.out.println("El archivo "+archivoDelObjetoActual(f)+
					" esta ahora protegido contra escritura y lectura");
		}else{
			System.out.println("El archivo "+archivoDelObjetoActual(f)+
					" ya esta protegido contra escritura y lectura");
		}
	}

	public void eliminaArchivo(){//Si el archivo existe es eliminado,si no, imprime Error.
		File f = null;
		try{
			f=new File(nombreArc);
			if(!existeArchivo(f)){
				System.out.println("Error, al eliminar el archivo "+archivoDelObjetoActual(f)+", no existe");
			}else{
				f.delete();
				System.out.println("El archivo "+archivoDelObjetoActual(f)+", ha sido eliminado con exito");
			}
		}catch (Exception e) {
			System.out.println("Error al eliminar el archivo:  "+archivoDelObjetoActual(f)+
					"\n"+ e.getMessage());
		}
	}

	public void creaArchivo(){//Crea un archivo con el nombre del contructor.
		File f = null;
		try{
			f=new File(nombreArc);
			if(existeArchivo(f)){
				System.out.println("Error, al crear el archivo "+archivoDelObjetoActual(f)+", ya existe");
			}else if(f.createNewFile()){
				System.out.println("Archivo "+archivoDelObjetoActual(f)+" ha sido creado con exito");
			}
		}catch (IOException e) {
			System.out.println("Error a la hora de la creacion del archivo: "+
					archivoDelObjetoActual(f)+"\n"+ e.getMessage());
			e.printStackTrace();
		}
	}

	//Si el archivo existe, escribe una cadena la final del archivo y lo cierra.
	public void escribeArchivo(String cadena){
		File f=new File(nombreArc);
		FileWriter fw = null;
		PrintWriter pw;
		if(manipularArchivo(f)){
			if(existeArchivo(f)){
				try {
					fw=new FileWriter(f,true);
					pw=new PrintWriter(fw);
					pw.println(cadena);
				} catch (IOException e) {
					System.out.println("Error de Escritura en el archivo: "+e.getMessage());
					e.printStackTrace();
				}finally{
					try {
						if(fw!=null){
							fw.close();
						}
					} catch (Exception e2) {
						System.out.println("Error: " + e2.getMessage());
					}
				}
			}else{
				System.out.println("Error, cree el archivo "+archivoDelObjetoActual(f)+" primero");
			}
		}else{
			System.out.println("Error, el archivo "+archivoDelObjetoActual(f)+
					" no puede ser ni leido ni escrito");
		}
	}

	//Si el archivo existe, lee "n" numero de lineas del archivo y devuelve una
	//cadena con lo que leyo del archivo, de no existir manda error.
	public String leerArchivo(int numLineas){
		String texto="",temporal;
		File f=new File(nombreArc);
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader br = null;
		if(manipularArchivo(f)){
			if(existeArchivo(f)){
				try{
					fis=new FileInputStream(f);
					isr=new InputStreamReader(fis);
					br=new BufferedReader(isr);
					while (numLineas>0) {
						temporal = br.readLine();
						numLineas--;
						if(temporal!=null)
							texto=texto+"\n"+temporal;
						else{
							break;
						}
					}
				} catch (IOException e) {
					System.out.println("Error a la hora leer del archivo: "+e.getMessage());
					e.printStackTrace();
				}finally{
					try {
						br.close();
					} catch (IOException e) {
						System.out.println("Error a la hora cerrar del archivo: "+e.getMessage());
						e.printStackTrace();
					}
				}
			}else{
				System.out.println("Error, cree el  "+archivoDelObjetoActual(f)+" archivo primero");
			}
		}else{
			System.out.println("Error, el archivo "+archivoDelObjetoActual(f)+
					" no puede ser ni leido ni escrito");
		}
		return texto;
	}

	public static void main(String[] args) {
		Archivos arc=new Archivos("Galarza.txt");
		arc.creaArchivo();
		arc.escribeArchivo("Medina Galarza Jose Arturo");
		Archivos arc2=new Archivos("hola.txt");
		arc2.creaArchivo();
		arc.escribeArchivo("Lucia Fletes");
		for (int i = 0; i <15; i++) {
			arc2.escribeArchivo("Hola "+i);
		}
		System.out.println(arc.leerArchivo(30));
		arc.eliminaArchivo();
		System.out.println(arc2.leerArchivo(12));
		arc2.eliminaArchivo();
	}
}
