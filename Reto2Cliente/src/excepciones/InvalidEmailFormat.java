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
public class InvalidEmailFormat extends Exception {

    /**
     * Creates a new instance of <code>InvalidEmailFormat</code> without detail
     * message.
     */
    public InvalidEmailFormat() {
    }

    /**
     * Constructs an instance of <code>InvalidEmailFormat</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidEmailFormat(String msg) {
        super(msg);
    }
}
