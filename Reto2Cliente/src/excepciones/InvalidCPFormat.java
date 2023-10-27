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
public class InvalidCPFormat extends Exception {

    /**
     * Creates a new instance of <code>InvalidCPFormat</code> without detail
     * message.
     */
    public InvalidCPFormat() {
    }

    /**
     * Constructs an instance of <code>InvalidCPFormat</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidCPFormat(String msg) {
        super(msg);
    }
}
