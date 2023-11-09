/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.InterfaceClienteServidor;
import clases.Mensaje;
import clases.MessageEnum;
import clases.Usuario;
import excepciones.CheckSignInException;
import excepciones.CheckSignUpException;

import java.util.logging.Logger;
import sockets.ClienteSocket;

/**
 *
 * @author Iñigo
 */
public class Implementacion implements InterfaceClienteServidor {

    private static final Logger logger = Logger.getLogger(Implementacion.class.getName());

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

    @Override
    public void closeApli() {
        logger.info("Finalizando la aplicación...");
        System.exit(0);
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

    @Override
    public Mensaje conexion(Mensaje msj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
