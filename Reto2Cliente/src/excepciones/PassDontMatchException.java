/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Esta es la excepcion del registro cuando las contraseañas introducidas no
 * coinciden
 *
 * @author Gonzalo
 */
public class PassDontMatchException extends Exception {

    /**
     * Creates a new instance of <code>PassDontMatch</code> without detail
     * message.
     */
    public PassDontMatchException() {
    }

    /**
     * Constructs an instance of <code>PassDontMatch</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public PassDontMatchException(String msg) {
        super(msg);
    }
}
