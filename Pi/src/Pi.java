/*
 * Ing. José Arturo Medina Galarza
 */

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class Pi extends Frame implements WindowListener,ActionListener{
	private static final long serialVersionUID = 1L;
	private Button botoncomenzar,botonlimpiar;
	private Panel nivel1,nivel2,nivel3,nivel4,nivel5,nivel6;
	private TextField campotextodelta;
	private TextArea resultado;
	private Label campotextoreloj;
	private JRadioButton rbleibniz,rbsimpson,rbtrapecio,rbsec,rbhilo;
	private ButtonGroup grupofunciones1,grupofunciones2;
	public long tinicial=0,tfinal=0;
	public static final String PI=""+Math.PI;

	public Pi() {
		super("Super PI Galarza");
		setSize(512, 256);
		setLocation(200, 200);
		addWindowListener(this);
		setLayout(new GridLayout(8,1));
		botoncomenzar=new Button("Comenzar");
		botonlimpiar=new Button("Limpiar");
		botonlimpiar.setEnabled(false);
		botoncomenzar.addActionListener(this);
		botonlimpiar.addActionListener(this);
		campotextoreloj=new Label("Tiempo de Ejecucion:0000.0000 miliseg");
		campotextodelta=new TextField(10);
		campotextodelta.setFocusable(isFocusable());
		resultado=new TextArea(2,70);
		resultado.setEditable(false);
		/*
		resultado=new Label("                                                                   " +
				"                                                                                    ");
		*/
		rbleibniz=new JRadioButton("Leibniz",true);
		rbsimpson=new JRadioButton("Simpson", false);
		rbtrapecio=new JRadioButton("Trapecio", false);
		rbsec=new JRadioButton("Secuencial",true);
		rbhilo=new JRadioButton("Hilos",false);
		grupofunciones1=new ButtonGroup();
		grupofunciones2=new ButtonGroup();
		grupofunciones1.add(rbleibniz);
		grupofunciones1.add(rbsimpson);
		grupofunciones1.add(rbtrapecio);
		grupofunciones2.add(rbsec);
		grupofunciones2.add(rbhilo);

		
		nivel1=new Panel();
		nivel2=new Panel();
		nivel3=new Panel();
		nivel4=new Panel();
		nivel5=new Panel();
		nivel6=new Panel();

		add(new Label("                                             Valor de PI="+PI));
		add(nivel1);
		add(nivel2);
		add(nivel3);
		add(nivel4);
		add(nivel5);
		add(nivel6);
		
		nivel1.add(resultado);
		nivel2.add(campotextoreloj);
		
		nivel3.add(rbleibniz);
		nivel3.add(rbsimpson);
		nivel3.add(rbtrapecio);
		
		nivel4.add(rbsec);
		nivel4.add(rbhilo);

		nivel5.add(new Label("Delta"));
		nivel5.add(campotextodelta);
		nivel6.add(botoncomenzar);
		nivel6.add(botonlimpiar);

	}


	public static void main(String[] args) {
		Pi hpi=new Pi();
		hpi.setVisible(true);

	}
	
	public void imprimePrecision(String resultadotemp){
		int contador=0;
		while(contador<PI.length()){
			if(String.valueOf(resultadotemp.charAt(contador)).equals(String.valueOf(PI.charAt(contador)))){
				
      			resultado.append(String.valueOf(resultadotemp.charAt(contador)));
      			resultado.setForeground(Color.BLUE);
      			try {
	                        Thread.sleep(250);
                        } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
                        }
      		}else if(!String.valueOf(resultadotemp.charAt(contador)).equals(String.valueOf(PI.charAt(contador)))){
      			
      			resultado.append(String.valueOf(resultadotemp.charAt(contador)));
      			resultado.setForeground(Color.RED);
      			try {
	                        Thread.sleep(250);
                        } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
                        }
      		}
			contador++;
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		double temp=0;
		if(ae.getSource()==botoncomenzar){
			botoncomenzar.setEnabled(false);
			botonlimpiar.setEnabled(true);
			if(rbleibniz.isSelected()){
				/*Leibniz*/
				if(rbleibniz.isSelected()&&rbsec.isSelected()){//Leibniz Secuencial
					tinicial=System.currentTimeMillis();
					try {
						temp=Double.parseDouble(campotextodelta.getText());
					} catch (NumberFormatException e) {
						System.out.println(e);
					}
					Leibniz lbz=new Leibniz(temp,0);
					resultado.setText("\nValor calculado por   Leibniz" +
							"    Pi = ");
					this.imprimePrecision(""+lbz.metodoLeibniz());
					tfinal=System.currentTimeMillis();
					campotextoreloj.setText("Tiempo de Ejecucion:"+
							(tfinal-tinicial)+" miliseg");
				}
			}else if(rbtrapecio.isSelected()){
				/*Trapecio*/
				if(rbtrapecio.isSelected()&&rbsec.isSelected()){//Trapecio Secuencial
					tinicial=System.currentTimeMillis();
					try {
						temp=Double.parseDouble(campotextodelta.getText());
					} catch (NumberFormatException e) {
						System.out.println(e);
					}
					Trapecios tps=new Trapecios(temp,0);
					resultado.setText("\nValor calculado por Trapecios" +
							" Pi = "+tps.metodoTrapecios());
					tfinal=System.currentTimeMillis();
					campotextoreloj.setText("Tiempo de Ejecucion:"+
							(tfinal-tinicial)+" miliseg");
				}
			}
		}else if(ae.getSource()==botonlimpiar){
			botoncomenzar.setEnabled(true);
			botonlimpiar.setEnabled(false);
			tinicial=0;
			tfinal=0;
			temp=0;
			campotextoreloj.setText("Tiempo de Ejecucion:0000.0000 seg");
			resultado.setText("");
			campotextodelta.setText("");
		}

	}

	public void windowActivated(WindowEvent arg0) {}

	public void windowClosed(WindowEvent arg0) {}

	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}
	
	public void windowDeactivated(WindowEvent arg0) {}

	public void windowDeiconified(WindowEvent arg0) {}

	public void windowIconified(WindowEvent arg0) {}

	public void windowOpened(WindowEvent arg0) {}

}
