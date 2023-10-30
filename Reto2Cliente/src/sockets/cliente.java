package sockets;

import clases.Mensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David.
 */
public class cliente {

    private final String host = ResourceBundle.getBundle("Reto2Libreria.conexion").getString("host");
    private final int puerto = Integer.parseInt(ResourceBundle.getBundle("reto2Cliente.conexion").getString("puerto"));
    
    Mensaje msj2;
    
    public Mensaje socketCliente(Mensaje msj){
        Socket socket;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        
        try {
            socket = new Socket(host, puerto);
            
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(msj);
            
            ois = new ObjectInputStream(socket.getInputStream());
            msj2 = (Mensaje) ois.readObject();
            
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msj2;
    }

}
