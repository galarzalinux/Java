import java.rmi.RemoteException;
import java.awt.*;
import java.awt.image.*;

public class SobelAlgoritmo extends Canvas implements SobelRemoteException{
	private static final long serialVersionUID = 1L;

public BufferedImage Resultado(Image imagen, byte orientacion) throws RemoteException {
        int ancho, alto;
        //Image miimagen;
        BufferedImage gral, procesada;
        //Image i[]=new Image[4];
        alto=imagen.getHeight(this);
        ancho=imagen.getWidth(this);
        gral=new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        gral.getGraphics().drawImage(imagen, 0 , 0, null);


        
        System.out.println("Gral: "+gral.toString());
        
        /*i[0]=gral.getSubimage(0, 0, alto/2, ancho/2);
        i[1]=gral.getSubimage(0, ancho/2, alto/2, ancho-(ancho/2) );
        i[2]=gral.getSubimage(alto/2, 0, (alto)-alto/2, ancho/2);
        i[3]=gral.getSubimage(alto/2, ancho/2, (alto)-alto/2, ancho-(ancho/2) );*/

        procesada = SobelA(gral, orientacion);
        System.out.println("Resultado: "+procesada.toString());
        return procesada;
    }

    public BufferedImage SobelA(BufferedImage entrada,byte orientacion){
        BufferedImage ret = null;
        ConvolveOp  x;
        Kernel k;
        float []nucleo = new float [9];        
        switch(orientacion){
            case 0: //horizontal
                nucleo[0] = 1; nucleo[1] = 0; nucleo[2] = -1;
                nucleo[3] = 1; nucleo[4] = 0; nucleo[5] = -1;
                nucleo[6] = 1; nucleo[7] = 0; nucleo[8] = -1;
                break;
            case 1: //vertical
                nucleo[0] = 1; nucleo[1] = 1; nucleo[2] = 1;
                nucleo[3] = 0; nucleo[4] = 0; nucleo[5] = 0;
                nucleo[6] = -1; nucleo[7] = -1; nucleo[8] = -1;
                break;
        }
        k=new Kernel(3,3,nucleo);
        x=new ConvolveOp(k); 
        
        ret = new BufferedImage(entrada.getWidth(),entrada.getHeight(),
                BufferedImage.TYPE_INT_RGB);
		ret=x.filter(entrada,ret);

        return ret;
    }
}
