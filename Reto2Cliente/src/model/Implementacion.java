/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clases.InterfaceClienteServidor;
import clases.Mensaje;
import clases.MessageEnum;
import clases.Usuario;
import excepciones.CheckSignInException;
import excepciones.CheckSignUpException;

import java.util.logging.Logger;
import sockets.ClienteSocket;

/**
 * La clase Implementacion proporciona la implementación concreta de la interfaz
 * InterfaceClienteServidor. Se encarga de gestionar la comunicación con el
 * servidor a través de sockets y realizar las operaciones de inicio de sesión
 * (signIn) y registro de usuario (signUp). Además, incluye métodos para cerrar
 * la aplicación y realizar operaciones específicas de inserción y verificación
 * de usuarios.
 *
 * @author Iñigo
 */
public class Implementacion implements InterfaceClienteServidor {

    private static final Logger logger = Logger.getLogger(Implementacion.class.getName());

    /**
     * Realiza la operación de inicio de sesión (signIn) enviando un mensaje al
     * servidor.
     *
     * @param us El objeto Usuario con las credenciales de inicio de sesión.
     * @return Un objeto Mensaje que contiene la respuesta del servidor.
     */
    @Override
    public Mensaje signIn(Usuario us) {
        ClienteSocket csk = new ClienteSocket();
        Mensaje respuesta = new Mensaje();

        Mensaje msj = new Mensaje();
        msj.setUser(us);
        msj.setMessageEnum(MessageEnum.SIGNIN);

        respuesta = csk.conexion(msj);
        return respuesta;
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
        ClienteSocket csk = new ClienteSocket();
        Mensaje respuesta = new Mensaje();

        Mensaje msj = new Mensaje();
        msj.setUser(us);
        msj.setMessageEnum(MessageEnum.SIGNUP);

        respuesta = csk.conexion(msj);
        return respuesta;
    }

    /**
     * Cierra la aplicación. Este método finaliza la ejecución del programa.
     */
    @Override
    public void closeApli() {
        logger.info("Finalizando la aplicación...");
        System.exit(0);
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

    /**
     * Establece la conexión con el servidor y realiza una operación específica
     * enviando un mensaje.
     *
     * @param msj El objeto Mensaje que contiene la información a enviar al
     * servidor.
     * @return Un objeto Mensaje que contiene la respuesta del servidor.
     */
    @Override
    public Mensaje conexion(Mensaje msj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
