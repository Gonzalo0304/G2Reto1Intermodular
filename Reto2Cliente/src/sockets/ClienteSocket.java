package sockets;

import clases.InterfaceClienteServidor;
import clases.Mensaje;
import clases.MessageEnum;
import clases.Usuario;
import excepciones.CheckSignInException;
import excepciones.CheckSignUpException;
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
public class ClienteSocket implements InterfaceClienteServidor {

    private final String HOST = ResourceBundle.getBundle("clases.conexion").getString("host");
    private final int PUERTO = Integer.parseInt(ResourceBundle.getBundle("clases.conexion").getString("puerto"));

    Mensaje msj2;

    @Override
    public Mensaje signIn(Usuario us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje signUp(Usuario us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeApli() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensaje conexion(Mensaje respuesta) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
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
        } finally {
            try {
                oos.flush();
                oos.close();
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return msj;
    }

    @Override
    public MessageEnum insertUser(Usuario usuario) throws CheckSignUpException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer checkSignUp(Usuario usuario) throws CheckSignUpException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MessageEnum checkSignIn(Usuario usuario) throws CheckSignInException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
