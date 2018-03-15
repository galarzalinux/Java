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

public class Chat extends Frame {

	public static final long serialVersionUID=1L;
	private TextField campotextoip,campotextomensaje,campotextousuario;
	private TextArea areatexto;
	private Button boton;
	private String ip=null,mensajeenvia;

	public Chat(){
		super("Chat Galarza(TM)");
		setLayout(new BorderLayout());
		add("North", new PanelyBotones(1));
		add("Center",new PanelyBotones(2));
		add("South",new PanelyBotones(3));
		setSize(800,400);
		setLocation(300, 300);
		addWindowListener(new ManejadorVentana());
		boton.addActionListener(new ManejadorEvento());
		new Thread(new Receptor()).start();
	}

	public static void main(String[] args) {
		new Chat().setVisible(true);
	}    

	class PanelyBotones extends Panel{
		private static final long serialVersionUID = 1L;
		public PanelyBotones(int opcion){
			switch(opcion){
				case 1:
					campotextoip=new TextField(15);
					campotextousuario=new TextField(15);
					add(new Label("User"));
					add(campotextousuario);
					add(new Label("IP:"));
					add(campotextoip);
					add(new Label("Default IP=255.255.255.255"));
					break;
				case 2: 
					areatexto=new TextArea(15,85);
					add(areatexto);
					areatexto.setEditable(false);
					add(new Label("Powered by Galarza Engine"));
					break;
				case 3: 
					campotextomensaje=new TextField(50);
					boton=new Button("Enviar");
					add(new Label("Mensaje:"));
					add(campotextomensaje);
					add(boton);
					break;
			}
		}
	}

	class ManejadorEvento implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource()==boton){
				ip=(campotextoip.getText());
				if(ip.isEmpty())
					ip="255.255.255.255";
				if(campotextomensaje.getText().isEmpty()) {
					mensajeenvia=(campotextousuario.getText())+"|"+("N/A");
				}else {
					mensajeenvia=(campotextousuario.getText())+"|"+(campotextomensaje.getText());
				}
				campotextomensaje.setText("");
				campotextousuario.setEnabled(false);
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
				buffer=mensajeenvia.getBytes();
				try{
					dp=new DatagramPacket(buffer,buffer.length,InetAddress.getByName(ip),2001);
					socketEmision.send(dp);
				}catch(Exception e){
					System.out.print("Error  "+e.getMessage());
				}
				System.out.print("Cerrando socket emision...");
				socketEmision.close();
				System.out.println("hecho");
			}
		}
	}

	class Receptor implements Runnable{
		@Override
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
				while(true){
					socketRecepcion.receive(dp);
					System.out.println("IP Emisora: "+dp.getAddress().toString()+":");
					System.out.println(new String(buffer,0,dp.getLength()));
					areatexto.append("IP emisora:   "+dp.getAddress().toString());
					String temp=new String(buffer,0,dp.getLength());
					String[] splited= temp.split("\\|");
					areatexto.append("  Usuario:  "+splited[0]);
					areatexto.append("\tMensaje:   "+splited[1]);
					areatexto.append("\n");
				}
			}catch(IOException ioe){
				System.out.print("Error  "+ioe.getMessage());
			}catch (Exception e) {
				System.out.print("Error = "+e.getMessage());
			}
			finally {
				System.out.println("Cerrando socket recepcion...");
				socketRecepcion.close();
				System.out.println("hecho");
			}
		}
	}
}

class ManejadorVentana implements WindowListener{
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}