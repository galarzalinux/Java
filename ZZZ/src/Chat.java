/*
 * Taller de Sistemas Operativos Avanzados
 * Segundo Examen Parcial y Tarea B (Chat)
 * Medina Galarza José Arturo
 * 303683133
 */

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.Thread;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.InetAddress;
import java.io.IOException;
import java.security.KeyStore;

public class Chat extends Frame {

	public static final long serialVersionUID=1L;
	private TextField campotextoip,campotextomensaje;
	private TextArea areatexto;
	private Button boton;
	private static boolean status;

	public static void Exit_status(){
		status = false;
	}

    public Chat(){
		super("Chat Galarza");
		setLayout(new BorderLayout());
		PanelyBotones panelnorte =new PanelyBotones(1);
		PanelyBotones panelcentro=new PanelyBotones(2);
		PanelyBotones panelsur=new PanelyBotones(3);
		add("North", panelnorte);
		add("Center",panelcentro);
		add("South",panelsur);
		setSize(900,400);
		ManejadorVentana mv = new ManejadorVentana();
		addWindowListener(mv);
		ManejadorEvento me = new ManejadorEvento();
		boton.addActionListener(me);
		status = true;
		Receptor re=new Receptor();
		Thread hilorecibe =new Thread(re);
		hilorecibe.start();
	}

	public static void main(String[] args) {
		Chat obj;
		obj =new Chat();
		obj.setVisible(true);
	}

	class PanelyBotones extends Panel{
		private static final long serialVersionUID = 1L;
		public PanelyBotones(int opcion){
			switch(opcion){
				case 1: campotextoip=new TextField(15);
					add(new Label("IP:"));
					add(campotextoip);
					add(new Label("Default IP=255.255.255.255"));
				break;
				case 2: areatexto=new TextArea(15,85);
					add(areatexto);
					areatexto.setEditable(false);
					add(new Label("Powered by Galarza Engine"));
				break;
				case 3: campotextomensaje=new TextField(50);
					boton=new Button("Enviar");
					add(new Label("Mensaje:"));
					add(campotextomensaje);
					add(boton);
				break;
			}
		}
	}

	class ManejadorEvento implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource()==boton){
                String ip = (campotextoip.getText());
				if(ip.isEmpty())
					ip ="255.255.255.255";
                String mensajeenvia = (campotextomensaje.getText());
				campotextomensaje.setText("");
				DatagramSocket socketEmision=null;
				DatagramPacket dp;
				int puertoSalida=2002;
				byte[] buffer;
				System.out.print("Iniciando socket emision en puerto "+puertoSalida+"...");
				try{
					socketEmision=new DatagramSocket(puertoSalida);
					System.out.println("hecho");
				}catch(SocketException e){
					System.out.println("Error iniciando socket: "+e.getMessage());
				}
				buffer= mensajeenvia.getBytes();
				try{
					dp=new DatagramPacket(buffer,buffer.length,InetAddress.getByName(ip),2001);
                    assert socketEmision != null;
                    socketEmision.send(dp);
					System.out.print("Cerrando socket emision...");
                    socketEmision.close();
					System.out.println("hecho");
				}catch(Exception e){
					System.out.print("Error  "+e.getMessage());
				}
			}
		}
	}


	class Receptor implements Runnable{
		public void run(){
			DatagramSocket socketRecepcion=null;
			DatagramPacket dp;
			int puertoEntrada=2001;
			byte[] buffer=new byte[1024];
			areatexto.append("Iniciando socket recepcion en puerto "+puertoEntrada+"...\n");
			try{
				socketRecepcion=new DatagramSocket(puertoEntrada);
				areatexto.append("hecho\n");
			}catch(SocketException e){
				areatexto.append("Error iniciando socket: "+e.getMessage());
			}
			try{
				dp=new DatagramPacket(buffer,buffer.length);
				do{
                    assert socketRecepcion != null;
                    socketRecepcion.receive(dp);
					System.out.print("IP emisora: "+dp.getAddress().toString()+":");
					System.out.println(new String(buffer,0,dp.getLength()));
                    String mensajerecibido = "IP emisora:   " + dp.getAddress().toString();
					mensajerecibido = mensajerecibido +"\nMensaje:   "+new String(buffer,0,dp.getLength())+"\n";
					areatexto.append(mensajerecibido);
					areatexto.append("\n");
				}while(status);
			}catch(IOException e){
				System.out.print("Error  "+e.getMessage());
			}
			System.out.print("Cerrando socket recepcion...");
			socketRecepcion.close();
			System.out.println("hecho");
		}
	}

}

class ManejadorVentana implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		Chat.Exit_status();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}

