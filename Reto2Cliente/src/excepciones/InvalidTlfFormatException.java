/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Esta es la excepcion para cuando el formato dle telefono es incorrecto a la
 * hora de registrarse
 *
 * @author Gonzalo
 */
public class InvalidTlfFormatException extends Exception {

    /**
     * Creates a new instance of <code>InvalidTlfFormat</code> without detail
     * message.
     */
    public InvalidTlfFormatException() {
    }

    /**
     * Constructs an instance of <code>InvalidTlfFormat</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidTlfFormatException(String msg) {
        super(msg);
    }
}
