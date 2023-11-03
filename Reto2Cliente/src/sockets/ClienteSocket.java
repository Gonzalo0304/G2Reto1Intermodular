package sockets;

import clases.Mensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InterfazCliente;

/**
 *
 * @author David.
 */
public class ClienteSocket implements InterfazCliente {

    private final String HOST = ResourceBundle.getBundle("clases.conexion").getString("host");
    private final int PUERTO = Integer.parseInt(ResourceBundle.getBundle("clases.conexion").getString("puerto"));

    Mensaje msj2;

    @Override
    public Mensaje signIn(Mensaje respuesta) {
        ObjectOutputStream oos;
        ObjectInputStream ois;
        Mensaje msj = respuesta;

        try {
            Socket sk = new Socket(HOST, PUERTO);
            oos = new ObjectOutputStream(sk.getOutputStream());

            oos.writeObject(respuesta);

            ois = new ObjectInputStream(sk.getInputStream());
            msj = (Mensaje) ois.readObject();

        } catch (IOException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }

        return msj;
    }

    @Override
    public Mensaje signUp(Mensaje respuesta) {
        ObjectOutputStream oos;
        ObjectInputStream ois;
        Mensaje msj = null;

        try {
            Socket sk = new Socket(HOST, PUERTO);
            oos = new ObjectOutputStream(sk.getOutputStream());

            oos.writeObject(respuesta);

            ois = new ObjectInputStream(sk.getInputStream());
            msj = (Mensaje) ois.readObject();

        } catch (IOException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }

        return msj;
    }

    @Override
    public void closeApli() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    
    public Mensaje vueltaMensaje(Mensaje msj){
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
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msj2;
    }
     */
}
