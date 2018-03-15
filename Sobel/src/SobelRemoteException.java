import java.awt.image.BufferedImage;
import java.awt.Image;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SobelRemoteException extends Remote{
    public BufferedImage Resultado(Image imagen, byte orientacion)
            throws RemoteException;
}
