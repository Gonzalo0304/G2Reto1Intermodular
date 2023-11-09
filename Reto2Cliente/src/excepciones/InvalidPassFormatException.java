/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Esta es la excepcion para cuando el formato d ela contraseña es incorrecto a
 * la hora de registrarse
 *
 * @author Gonzalo
 */
public class InvalidPassFormatException extends Exception {

    /**
     * Creates a new instance of <code>InvalidPassFormat</code> without detail
     * message.
     */
    public InvalidPassFormatException() {
    }

    /**
     * Constructs an instance of <code>InvalidPassFormat</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidPassFormatException(String msg) {
        super(msg);
    }
}
