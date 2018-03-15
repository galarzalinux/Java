import java.rmi.Naming;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

class mostrarImagenes extends JPanel{
	private static final long serialVersionUID = 1L;
	ImageIcon fondo;

	public mostrarImagenes(Image imagen){
		fondo=new ImageIcon(imagen);
		this.setSize(400, 00);
	}

	@Override
	public void paintComponent(Graphics g){
		g.drawImage(fondo.getImage(),0,0,400,300,null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

public class SobelCliente extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	ImageIcon archivo;
	Image imagen,ih,iv;
	BufferedImage resh, resv;
	JButton continuar;
	JFrame res1, res2;
	SobelRemoteException rth, rtv;
	mostrarImagenes img1,imgh, imgv;
	String ipserverh="localhost";//servidor SobelHorizontal horizontal
	String ipserverv="localhost";//servidor SobelVertical vertical

	public SobelCliente() {
		super("Sobel");
		this.setSize(460,500);
		this.setBackground(Color.green);

		try{
			rth=(SobelRemoteException)Naming.lookup("rmi://"+ipserverh+":2000/Sobelh");
			rtv=(SobelRemoteException)Naming.lookup("rmi://"+ipserverv+":2001/Sobelv");
			this.setLayout(null);
			this.setResizable(false);

			this.setIconImage (new ImageIcon("cliente.png").getImage());

			archivo=new ImageIcon("imagen.jpg");
			imagen=archivo.getImage();

			continuar = new JButton("Procesar");
			continuar.addActionListener(this);
			continuar.setFont(new Font("Tahoma",Font.PLAIN,20));
			continuar.setForeground(Color.BLACK);
			continuar.setBounds(30,360,400,90);

			img1 = new mostrarImagenes(imagen);

			img1.setBounds(30,30,400,300);

			this.add(continuar);
			this.add(img1);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);

		}
		catch(Exception e){
			System.out.println();
			System.out.println("Otra");
			System.out.println(e);
		}
	}

	public void actionPerformed(ActionEvent ae){
		try{
			if(ae.getActionCommand().equals("Procesar")){

				resh=rth.Resultado(imagen,(byte) 0);
				resv=rtv.Resultado(imagen,(byte) 1);



				res1 = new JFrame("Procesado Horizontal");
				res2 = new JFrame("Procesado Vertical");
				res1.setLayout(null);
				res2.setLayout(null);
				res1.setSize(460,400);
				res2.setSize(460,400);
				res1.setIconImage (new ImageIcon("cliente.png").getImage());
				res2.setIconImage (new ImageIcon("cliente.png").getImage());

				ih=toImage(resh);
				iv=toImage(resv);

				imgh = new mostrarImagenes(ih);
				imgv = new mostrarImagenes(iv);

				imgh.setBounds(30,30,400,300);
				imgv.setBounds(30,30,400,300);

				res1.add(imgh);
				res2.add(imgv);
				res1.setVisible(true);
				res2.setVisible(true);
				res1.setLocation(462,0);
				res2.setLocation(0,501);
				res1.setResizable(false);
				res2.setResizable(false);
			}
		}
		catch(NullPointerException re){
			System.out.println(re.getCause());
		}
		catch(Exception re){
			System.out.println(re.toString());
		}
	}

	public static Image toImage(BufferedImage bufferedImage) {
		return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
	}

	public static void main(String[] x){
		//SobelCliente tlr=new SobelCliente();
	}

}