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
 * La clase cliente se encarga de establecer la comunicación con el servidor a través de sockets.
 * Proporciona un método para enviar un objeto Mensaje al servidor y recibir la respuesta correspondiente.
 *
 * Uso:
 * Se utiliza para enviar mensajes al servidor y recibir las respuestas correspondientes. Se instancia
 * un objeto de esta clase, se configuran las propiedades necesarias (como el host y el puerto del servidor),
 * y luego se utiliza el método socketCliente para enviar un mensaje al servidor.
 *
 * Ejemplo:
 * ```java
 * cliente clienteSocket = new cliente();
 * Mensaje respuestaServidor = clienteSocket.socketCliente(msj);
 * ```
 *
 * @author David
 */
public class cliente {

    private final String host = ResourceBundle.getBundle("Reto2Libreria.conexion").getString("host");
    private final int puerto = Integer.parseInt(ResourceBundle.getBundle("reto2Cliente.conexion").getString("puerto"));
    
    Mensaje msj2;
    
     /**
     * Establece la conexión con el servidor y envía un objeto Mensaje, luego recibe la respuesta del servidor.
     *
     * @param msj El objeto Mensaje a enviar al servidor.
     * @return Un objeto Mensaje que contiene la respuesta del servidor.
     */
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
