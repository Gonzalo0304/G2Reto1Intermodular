/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * Esta es la excepcion para cuando los campos del registro no estan todos
 * informados
 *
 * @author Gonzalo
 */
public class NotCompleteExceptionException extends Exception {

    /**
     * Creates a new instance of <code>NotCompleteException</code> without
     * detail message.
     */
    public NotCompleteExceptionException() {
    }

    /**
     * Constructs an instance of <code>NotCompleteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotCompleteExceptionException(String msg) {
        super(msg);
    }
}
