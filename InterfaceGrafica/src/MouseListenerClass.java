import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MouseListenerClass implements MouseMotionListener,MouseListener{

	private JFrame marco;
	private JTextField campotexto1,campotexto2;
	private JPanel panel;

	public MouseListenerClass() {
		marco=new JFrame("Mouse Listener");
		campotexto1=new JTextField(25);
		campotexto2=new JTextField(15);
		panel=new JPanel();
		marco.setVisible(true);
		marco.setSize(500,450);
		/*
		marco.add(new Label("Etiqueta"),BorderLayout.NORTH);
		marco.add(campotexto1,BorderLayout.SOUTH);
		*/
		
		panel.add(new Label("Etiqueta"));
		panel.add(campotexto1);
		marco.add(panel);
		marco.add(panel,BorderLayout.NORTH);
		marco.add(campotexto2,BorderLayout.SOUTH);
		 
		marco.addMouseListener(this);
		marco.addMouseMotionListener(this);
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

		campotexto2.setText("Coordenadas, X= "+e.getX()+" Y= "+e.getY());
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		//Cuando el mouse entra a un componente.
		campotexto1.setText("Cadena de prueba cuando entra");
	}

	public void mouseExited(MouseEvent e) {
		//Cuando el mouse sale a un componente.
		campotexto1.setText("Cadena de prueba cuando sale");
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public static void main(String[] args) {
		new MouseListenerClass();
	}
}
