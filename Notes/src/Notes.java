import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Notes extends Frame{

	private static final long serialVersionUID = 1L;
	private Choice user, platform;
	private Button boton;

	public Notes() {
		super("Galarza Notes");
		setLayout(new BorderLayout());
		PanelyBotones panelnorte =new PanelyBotones(1);
		PanelyBotones panelcentro=new PanelyBotones(2);
		add("North", panelnorte);
		add("Center",panelcentro);
		setSize(400,200);
		ManejadorVentana mv = new ManejadorVentana();
		addWindowListener(mv);
		ManejadorEvento me = new ManejadorEvento();
		boton.addActionListener(me);
	}

	public static void main(String[] args) {
		Notes n;
		n=new Notes();
		n.setVisible(true);
	}
	
	class PanelyBotones extends Panel{
		private static final long serialVersionUID = 1L;
		public PanelyBotones(int opcion){
			switch(opcion){
				case 1: 
					user=new Choice();
					platform=new Choice();
					user.add("jmedinax");
					
					platform.add("");
					platform.add("clf");
					
					add(user);
					add(platform);
					
				break;
				case 2: 
					boton=new Button("Enviar");
					add(boton);
					add(new Label("Powered by Galarza Engine"));
				break;
			}
		}
	}
	
	class ManejadorEvento implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource()==boton){
				System.out.println(user.getSelectedItem() 
						+"_"+platform.getSelectedItem());
			}
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
