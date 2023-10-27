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
public class InvalidTlfFormat extends Exception {

    /**
     * Creates a new instance of <code>InvalidTlfFormat</code> without detail
     * message.
     */
    public InvalidTlfFormat() {
    }

    /**
     * Constructs an instance of <code>InvalidTlfFormat</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidTlfFormat(String msg) {
        super(msg);
    }
}
