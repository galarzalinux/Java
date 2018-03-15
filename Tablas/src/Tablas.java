/*
 * José Arturo Medina Galarza
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Tablas extends Frame implements WindowListener,ActionListener{
	private static final long serialVersionUID = 1L;
	private Panel panel;
	private Label etq,campopregunta;
	private TextField camporespuesta;
	private Button botonaceptar;
	public static final int MAX=20;
	public int counter=0,resultado=0,val1,val2,aciertos=0;
	public long relojinicial=0,relojfinal=0;
	public String temp="";


	public Tablas() {
		super("Tablas de Multiplicar");
		setSize(330, 150);
		setLocation(300, 300);
		addWindowListener(this);
		setLayout(new BorderLayout());
		campopregunta =new Label("");
		panel=new Panel();
		camporespuesta=new TextField(12);
		etq=new Label();
		campopregunta.setFont(new Font("Arial",Font.PLAIN,16));
		etq.setFont(new Font("Tahoma",Font.BOLD,14));
		botonaceptar=new Button("Aceptar");
		panel.add(new Label("Respuesta"));
		panel.add(camporespuesta);
		panel.add(botonaceptar);
		add(campopregunta,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		add(etq,BorderLayout.SOUTH);
		this.inicializa();
		relojinicial=System.currentTimeMillis();
		botonaceptar.addActionListener(this);
	}

	public static void main(String[] args) {
		Tablas t=new Tablas();
		t.setVisible(true);
	}

	public void inicializa(){
		val1=(int)((Math.random()*12)+1);
		val2=(int)((Math.random()*12)+1);
		campopregunta.setText(" Pregunta "+(counter+1)+" de "+MAX+"         "+val1+" x "+val2);
	}

      public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonaceptar&&counter<MAX){
			temp=camporespuesta.getText();

			try{
				resultado=Integer.parseInt(temp.trim());
			}catch(NumberFormatException nfe){
				nfe.printStackTrace();
			}
			if(val1*val2==resultado){
				botonaceptar.setEnabled(false);
				etq.setForeground(Color.green);
				etq.setText("Respuesa Correcta");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				etq.setText("");
				camporespuesta.setText("");
				counter++;
				aciertos++;
				botonaceptar.setEnabled(true);
				camporespuesta.setFocusable(isFocusable());
			}else{
				botonaceptar.setEnabled(false);
				etq.setForeground(Color.red);
				etq.setText("Respuesta Equivocada");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				etq.setText("");
				camporespuesta.setText("");
				counter++;
				botonaceptar.setEnabled(true);
				camporespuesta.setFocusable(isFocusable());
			}
			if(counter<MAX){
				this.inicializa();
			}else{
				botonaceptar.setEnabled(false);
				camporespuesta.setText("");
				camporespuesta.setEnabled(false);
				campopregunta.setForeground(Color.orange);
				relojfinal=System.currentTimeMillis();
				campopregunta.setText("Tiempo Trancurrido = "+
				((relojfinal-relojinicial)/1000)+" segundos");
				etq.setForeground(Color.blue);
				etq.setText(" Aciertos = "+aciertos+" Errores = "+(MAX-aciertos)+
						"  Porcentaje = "+((aciertos*100)/MAX)+"%");
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}
}
