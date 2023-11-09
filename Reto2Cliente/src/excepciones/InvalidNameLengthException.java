/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Esta es la excepcion para cuando la logitud del Nombre esta mal introducida a la hora de registrarse
 * en el registro
 *
 * @author Gonzalo
 */
public class InvalidNameLengthException extends Exception {

    /**
     * Creates a new instance of <code>InvalidNameLength</code> without detail
     * message.
     */
    public InvalidNameLengthException() {
    }

    /**
     * Constructs an instance of <code>InvalidNameLength</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidNameLengthException(String msg) {
        super(msg);
    }
}
