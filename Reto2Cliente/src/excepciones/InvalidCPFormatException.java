/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Esta es la excepcion para cuando el formato del Codigo postal esta mal
 * introducido a la hora de registrarse
 *
 * @author Gonzalo
 */
public class InvalidCPFormatException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCPFormat</code> without detail
     * message.
     */
    public InvalidCPFormatException() {
    }

    /**
     * Constructs an instance of <code>InvalidCPFormat</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidCPFormatException(String msg) {
        super(msg);
    }
}
