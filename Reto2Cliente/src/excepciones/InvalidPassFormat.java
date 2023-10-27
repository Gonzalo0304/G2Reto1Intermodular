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
public class InvalidPassFormat extends Exception {

    /**
     * Creates a new instance of <code>InvalidPassFormat</code> without detail
     * message.
     */
    public InvalidPassFormat() {
    }

    /**
     * Constructs an instance of <code>InvalidPassFormat</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidPassFormat(String msg) {
        super(msg);
    }
}
