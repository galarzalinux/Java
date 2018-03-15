import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class MiFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public MiFrame() {
		new JFrame("Mi ventana");
		new JLabel("Mi etiqueta");
		JButton b1=new JButton("Boton 1");
		JButton b2=new JButton("Boton 2");
		JButton b3=new JButton("Boton 3");
		JButton b4=new JButton("Boton 4");
		JButton b5=new JButton("Boton 5");
		//BorderLayout diseno=new BorderLayout();
		GridLayout diseno=new GridLayout(3,2);
		//miFrame.getContentPane().add(etiqueta);
		Container contenedor=getContentPane();
		contenedor.setLayout(diseno);
		contenedor.add(b1,BorderLayout.CENTER);
		contenedor.add(b2,BorderLayout.NORTH);
		contenedor.add(b3,BorderLayout.SOUTH);
		contenedor.add(b4,BorderLayout.EAST);
		contenedor.add(b5,BorderLayout.WEST);
		diseno.layoutContainer(getContentPane());
		//miFrame.pack();
		setVisible(true);
		setSize(300,300);
		/*
		miFrame.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}
				);
		 */
	}

	public static void main(String[] args) {
		MiFrame dah=new MiFrame();
		dah.setVisible(true);
	}

}
