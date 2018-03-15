import java.rmi.*;
import java.awt.*;
import javax.swing.*;

public class SobelHorizontal extends JFrame {
	private static final long serialVersionUID = 1L;
	SobelAlgoritmo rt;
	JLabel a;
	String ip="localhost";// ip de la maquina servidor Sobel Horizontal

    @SuppressWarnings("deprecation")
public SobelHorizontal(){
    	super("Servidor RMI Horizontal");

    	try{
    		Runtime.getRuntime().exec("rmiregistry 2000");

    		System.setProperty("java.security.policy", "rmi.policy");
			System.setSecurityManager( new RMISecurityManager() );

			rt = new SobelAlgoritmo();
			Naming.rebind("rmi://"+ip+":2000/Sobelh",rt);
	    	
        	this.setIconImage (new ImageIcon("servidor.png").getImage());


			a=new JLabel("Servidor Sobel Horizontal Disponible");
			a.setFont(new Font("Tahoma",Font.BOLD,30));
			a.setForeground(Color.GREEN);
			this.add(a);
			this.setResizable(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.pack();
			this.setVisible(true);
    	}
    	catch(Exception e){
    		System.out.println("Se encontro el siguiente problema: \n\t\t"+e);
    		System.exit(1);
    	}
    }

    public static void main(String[] x)throws Exception{
    	new SobelHorizontal();
    }
}
