import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExamplePanel{
	JFrame marco;
	JPanel panel;
	JButton boton;
	JTextField caja;
	Label etiqu;

	JPanel panel1;
	JButton boton1;
	JTextField caja1;
	Label etiqu1;

	public ExamplePanel() {
		marco=new JFrame("Ventana");
		panel=new JPanel();
		boton=new JButton("Mi pinche boton");
		caja=new JTextField(10);
		etiqu=new Label("Si charcho!!");
		marco.setSize(400,400);
		marco.setVisible(true);
		panel.add(boton);
		panel.add(etiqu);
		panel.add(caja);
		marco.add(panel);

		panel1=new JPanel();
		boton1=new JButton("Mi pinche boton1");
		caja1=new JTextField(10);
		etiqu1=new Label("0 y van 2");
		panel1.add(boton1);
		panel1.add(etiqu1);
		panel1.add(caja1);
		marco.add(panel1);

		marco.add(panel,BorderLayout.CENTER);
		marco.add(panel1,BorderLayout.SOUTH);

		boton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				caja.setText("Si JalaException");
				caja1.setText("Fuck Yeah, si jalo!!");
			}
		});
	}

	public static void main(String[] args) {
		new ExamplePanel();
	}

}
