public class Conectame{

	public void conectar() throws MiException{
		boolean miConeccion=false;
		String serverName="Galarza-PC";
		int port=80;
		miConeccion=open(serverName,port);
		if(miConeccion==false){
			throw new MiException();
		}
	}
	
	public boolean open(String serverName,int port) {
	      return false;
      }
	
	public static void main(String[] args) throws MiException {
	            Conectame c=new Conectame();
	            c.conectar();
      }

}
