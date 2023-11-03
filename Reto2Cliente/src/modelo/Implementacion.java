/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Mensaje;
import java.util.logging.Logger;
import sockets.ClienteSocket;

/**
 *
 * @author Iñigo
 */
public class Implementacion implements InterfazCliente {

    private static final Logger logger = Logger.getLogger(Implementacion.class.getName());

    @Override
    public Mensaje signIn(Mensaje respuesta) {
        ClienteSocket socket = new ClienteSocket();
        respuesta = socket.signIn(respuesta);
        return respuesta;
    }

    @Override
    public Mensaje signUp(Mensaje respuesta) {
        ClienteSocket socket = new ClienteSocket();
        respuesta = socket.signUp(respuesta);
        return respuesta;
    }

    @Override
    public void closeApli() {
        logger.info("Finalizando la aplicación...");
        System.exit(0);
    }

}
