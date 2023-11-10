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
 * La clase ClienteSocket implementa la interfaz InterfaceClienteServidor y se
 * encarga de establecer la comunicación con el servidor a través de sockets.
 * Proporciona métodos para realizar operaciones como inicio de sesión (signIn),
 * registro de usuario (signUp), cierre de la aplicación (closeApli), inserción
 * de usuario, y verificación de registro e inicio de sesión.
 *
 * Uso: Se utiliza para enviar mensajes al servidor y recibir las respuestas
 * correspondientes. Además, incluye métodos específicos para realizar
 * operaciones relacionadas con el usuario y la aplicación.
 *
 * Ejemplo: ```java ClienteSocket clienteSocket = new ClienteSocket(); Mensaje
 * respuestaSignIn = clienteSocket.signIn(usuario); Mensaje respuestaSignUp =
 * clienteSocket.signUp(usuario); clienteSocket.closeApli(); ```
 *
 * @author David
 */
public class ClienteSocket implements InterfaceClienteServidor {

    private final String HOST = ResourceBundle.getBundle("clases.conexion").getString("host");
    private final int PUERTO = Integer.parseInt(ResourceBundle.getBundle("clases.conexion").getString("puerto"));

    Mensaje msj2;

    /**
     * Realiza la operación de inicio de sesión (signIn) enviando un mensaje al
     * servidor.
     *
     * @param us El objeto Usuario con las credenciales de inicio de sesión.
     * @return Un objeto Mensaje que contiene la respuesta del servidor.
     */
    @Override
    public Mensaje signIn(Usuario us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Realiza la operación de registro de usuario (signUp) enviando un mensaje
     * al servidor.
     *
     * @param us El objeto Usuario con los datos para el registro.
     * @return Un objeto Mensaje que contiene la respuesta del servidor.
     */
    @Override
    public Mensaje signUp(Usuario us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Cierra la aplicación. Este método finaliza la ejecución del programa.
     */
    @Override
    public void closeApli() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Establece la conexión con el servidor y realiza una operación específica
     * enviando un mensaje.
     *
     * @param respuesta El objeto Mensaje que contiene la información a enviar
     * al servidor.
     * @return Un objeto Mensaje que contiene la respuesta del servidor.
     */
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

    /**
     * Inserta un nuevo usuario en el sistema.
     *
     * @param usuario El objeto Usuario a insertar.
     * @return Un valor de tipo MessageEnum que representa el resultado de la
     * operación.
     * @throws CheckSignUpException Si ocurre un error durante la operación de
     * registro.
     */
    @Override
    public MessageEnum insertUser(Usuario usuario) throws CheckSignUpException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Verifica el registro de un usuario en el sistema.
     *
     * @param usuario El objeto Usuario a verificar.
     * @return Un entero que representa el resultado de la verificación.
     * @throws CheckSignUpException Si ocurre un error durante la verificación.
     */
    @Override
    public Integer checkSignUp(Usuario usuario) throws CheckSignUpException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Verifica el inicio de sesión de un usuario en el sistema.
     *
     * @param usuario El objeto Usuario a verificar.
     * @return Un valor de tipo MessageEnum que representa el resultado de la
     * verificación.
     * @throws CheckSignInException Si ocurre un error durante la verificación.
     */
    @Override
    public MessageEnum checkSignIn(Usuario usuario) throws CheckSignInException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
