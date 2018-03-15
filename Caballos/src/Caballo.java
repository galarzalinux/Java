/*
 * José Arturo Medina Galarza
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
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

public class Caballo extends Frame implements WindowListener,ActionListener{
	private static final long serialVersionUID = 1L;
	private Button botoncomienza;
	private TextArea areaprincipal;
	private TextField valorinicial,areaejex,areaejey;
	private Panel mipanel;
	private Checkbox caja;
	public boolean q;
	public int n=0,ncuad,ejeiniciox,ejeinicioy;
	public int[][] tablero;
	public int[] ejex={ -1,-2,-2,-1, 1, 2, 2, 1 };
	public int[] ejey={ -2,-1, 1, 2, 2, 1,-1,-2 };

	public Caballo() {
		super("Recorrido del Caballo");
		setSize(300, 300);
		setLocation(300, 300);
		addWindowListener(this);
		setLayout(new BorderLayout());
		areaprincipal=new TextArea(100,100);
		botoncomienza=new Button("Inicio");
		valorinicial=new TextField(1);
		areaejex=new TextField(1);
		areaejey=new TextField(1);
		caja=new Checkbox();
		mipanel=new Panel(new GridLayout(2,6));
		mipanel.add(new Label("P. Inicial "));
		mipanel.add(new Label("X"));
		mipanel.add(areaejex);
		mipanel.add(new Label("Y"));
		mipanel.add(areaejey);
		mipanel.add(new Label("Todos"));
		mipanel.add(caja);
		mipanel.add(new Label("Tablero"));
		mipanel.add(valorinicial);
		mipanel.add(botoncomienza);
		add(areaprincipal,BorderLayout.CENTER);
		add(mipanel, BorderLayout.SOUTH);
		botoncomienza.addActionListener(this);
	}

	public static void main(String[] args) {
		Caballo c=new Caballo();
		c.setVisible(true);
	}

	public void inicializa(int x, int y){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tablero[i][j]=0;
			}
		}
		ncuad=n*n;
		tablero[x][y]=1;//Punto de comienzo
	}

	void imprime(){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(tablero[i][j]<10)
					areaprincipal.append("|0"+tablero[i][j]);
				else
					areaprincipal.append("|"+tablero[i][j]);
			}
			areaprincipal.append("|\n");
			for (int k = 0; k < n; k++) {
				areaprincipal.append("-----");  
			}
			areaprincipal.append("\n");
		}
		areaprincipal.append("\n\n");
	}

	void mover(int i, int pos_x, int pos_y){
		int k, u, v;
		k = 0;
		q=true;
		do {
			u = pos_x + ejex[k]; v = pos_y + ejey[k]; // seleccionar candidato 
			if (u >= 0 && u < n && v >= 0 && v < n) { // esta dentro de los limites? 
				if (tablero[u][v] == 0) {  // es valido? 
					tablero[u][v] = i;  // anota el candidato 
					if (i < ncuad) {  // llega al final del recorrido? 
						this.mover(i+1,u,v);
						if (q) tablero[u][v] = 0; // borra el candidato 
					}
					else q=false; // hay solucion 
				}
			}
			k++;
		} while (q && k < 8);
	}

	void mover(int i, int pos_x, int pos_y,String dah){
		int k, u, v;
		for (k = 0; k < 8; k++) {
			u = pos_x + ejex[k]; v = pos_y + ejey[k];
			if (u >= 0 && u < n && v >= 0 && v < n) { // esta dentro de los limites
				if (tablero[u][v] == 0) {
					tablero[u][v] = i;  
					if (i < ncuad)   
						this.mover(i+1,u,v,"");
					else this.imprime();
					tablero[u][v] = 0;  
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==botoncomienza){
			try {
				n=Integer.parseInt(valorinicial.getText());
				ejeiniciox=Integer.parseInt(areaejex.getText());
				ejeinicioy=Integer.parseInt(areaejey.getText());
			} catch (Exception e) {
				System.out.println("Error");
			}
			if(n!=0){
				valorinicial.setEnabled(false);
				areaejex.setEnabled(false);
				areaejey.setEnabled(false);
				tablero=new int[n][n];
				this.inicializa(ejeiniciox,ejeinicioy);
				if(!caja.getState())
					this.mover(2,ejeiniciox,ejeinicioy);// imprime solo la primer solucion 
				else
					this.mover(2,ejeiniciox,ejeinicioy,"");// imprime todas las soluciones
				this.imprime();
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0); 
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {}

}
