/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Gonzalo
 */
public class NotCompleteException extends Exception {

    /**
     * Creates a new instance of <code>NotCompleteException</code> without
     * detail message.
     */
    public NotCompleteException() {
    }

    /**
     * Constructs an instance of <code>NotCompleteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotCompleteException(String msg) {
        super(msg);
    }
}
