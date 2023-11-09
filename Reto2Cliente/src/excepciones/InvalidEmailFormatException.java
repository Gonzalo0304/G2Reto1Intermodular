/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Esta es la excepcion para cuando el formato de el Email esta mal introducido
 * a la hora de registrarse
 *
 * @author Gonzalo
 */
public class InvalidEmailFormatException extends Exception {

    /**
     * Creates a new instance of <code>InvalidEmailFormat</code> without detail
     * message.
     */
    public InvalidEmailFormatException() {
    }

    /**
     * Constructs an instance of <code>InvalidEmailFormat</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidEmailFormatException(String msg) {
        super(msg);
    }
}
